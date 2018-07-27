package exercise_nine;

public class Auto {


    public void setColor(String carColor){
        System.out.println("The color of the car is: " + carColor);
    }

    public void setBrand(String carBrand){
        System.out.println("The brand of the car is: " + carBrand);
    }

    public void setDoors(int numberOfDoors){
        System.out.println("The number of doors of the car are: " + numberOfDoors);
    }

    public void setMotorTyoe(String carMotor) {
        System.out.println("The Motor Type of the car is: " + carMotor);
    }

    public void calcTorque(int force, int engineRPMs){
        int torque = (force*5252)/engineRPMs;
        System.out.println("The torque of the car is: " + torque);
    }

    public void newCare(String color, String brand, int doors, String motor, int force, int engine){
        setColor(color);
        setBrand(brand);
        setDoors(doors);
        setMotorTyoe(motor);
        calcTorque(force,engine);
    }
}
