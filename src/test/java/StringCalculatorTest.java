import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void empty_input_returns_zero(){
        String input = "";
        int result = Calc.Sum(input);
        Assert.assertEquals(0,result);
    }
}
