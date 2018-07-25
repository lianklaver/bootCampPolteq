package exercises;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    private void printProduct(){
        System.out.println(multiply(1,2));
    }

    private int multiply(int numberOne, int numberTwo){
        return numberOne*numberTwo;
    }
}
