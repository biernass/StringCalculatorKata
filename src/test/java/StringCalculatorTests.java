import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTests {
    @Test
    public void empty_input_returns_zero()  {
        String input = "";
        int result = Calc.Sum(input);
        Assert.assertEquals( 0, result);
    }

    @Test
    public void one_number_in_input_returns_number()  {
        String input = "1";
        int result = Calc.Sum(input);
        Assert.assertEquals( 1, result);
    }

    @Test
    public void one_and_two_in_input_returns_numbers(){
        String input = "1,2";
        int result = Calc.Sum(input);
        Assert.assertEquals(3, result);
    }
}