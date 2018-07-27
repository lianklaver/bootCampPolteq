package exercise_nine;

import org.testng.annotations.Test;

public class TestAuto extends Auto {

    @Test
    public void createAuto(){
        Auto auto = new Auto();
        auto.setColor("Red");
    }
}
