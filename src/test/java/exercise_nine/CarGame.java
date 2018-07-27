package exercise_nine;

import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void newCareOne(){
        Auto carOne = new Auto();
        carOne.newCare("Red","Volvo", 4, "Beast", 200, 1000);
    }

    @Test
    public void newCareTwo(){
        Auto carOne = new Auto();

        carOne.setColor("Red");
        carOne.setBrand("Volvo");
        carOne.setDoors(4);
        carOne.setMotorTyoe("Beast");
        carOne.calcTorque(100,1000);
    }

    @Test
    public void newAdvancedCar(){
        AutoAdvanced carTwo = new AutoAdvanced("Volvo", 100, 1000);
    }


}

