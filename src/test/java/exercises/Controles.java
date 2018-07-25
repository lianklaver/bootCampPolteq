package exercises;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertSumisTwentyTwo(){
        int sum = 20+1;
        Assertions.assertThat(sum).as("Sum of numbers is 22").isEqualTo(22);
    }

    @Test
    public void assertTestWithBoolean(){
        String firstText = "Bla";
        String secondText = "BlaBla";
        boolean compareText = firstText.equals(secondText);

        Assertions.assertThat(compareText).as("First and second text is the same").isTrue();
    }

    @Test
    public void assertThatStringIsEmpty(){
        String empty = "notEmpty";
        Assertions.assertThat(empty).as("Just a test").isNullOrEmpty();
    }

    @Test
    public void assertStringContainsOnlyOnce(){
        String empty = "KippetjeKippetje";
        Assertions.assertThat(empty).as("Just a test").containsOnlyOnce("Kippetje");
    }
}
