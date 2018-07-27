package exercise_nine;

public class AutoAdvanced {

    public String brand;

    public AutoAdvanced(String brand, int force, int engineRPMs){
        this.brand = brand;
        System.out.println("Brand of the car is: " + brand);

        //torque formule
        int torque = (force*5252)/engineRPMs;
        System.out.println("The torque of the car is: " + torque);
    }
}
