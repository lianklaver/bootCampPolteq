package restAPITesten;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RestErgastTesten {

    @Test
    public void wordPressTest(){
        given().get("https://public-api.wordpress.com/rest/v1.1/sites/113768211/posts")
        .then().statusCode(200);

        given().parameters("number", 100, "order", "DESC").
                when().get("https://public-api.wordpress.com/rest/v1.1/sites/113768211/posts").
                then().statusCode(200);
    }

    @Test
    public void wordPressTestDos(){

        given().pathParam("number", 5).
                when().get("https://public-api.wordpress.com/rest/v1.1/sites/113768211/posts").
                then().log().all()
                .statusCode(200);

    }

    @Test
    public void maxVerstappenTest(){
        given().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().body("MRData.RaceTable.driverId", containsString("max_verstappen"));

    }


//      Werkt nog niet
//    @Test (dataProvider = "test")
//    public void maxVerstappenTestParams(Object drivers){
//        given().pathParam("season", 2016).pathParam("driver", "max_verstappen").get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").
//                then().body("MRData.RaceTable.driverId", containsString(drivers.toString()));
//
//    }
//
//
//    @DataProvider(name = "test")
//    public static Object[][] dataInput(){
//        return new String[][]{
//                {"drivers", "max_verstappen"}
//        };
//    }

    //pathParam("season", season)
    //<parameter name="season" value="2016" />

}



