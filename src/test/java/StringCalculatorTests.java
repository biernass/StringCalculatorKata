import jdk.jfr.events.ExceptionThrownEvent;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTests {

    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Test
    public void empty_input_returns_zero() {
        String input = "";
        int result = Calc.Sum(input);
        Assert.assertEquals(0, result);
    }

    @Test
    public void one_number_in_input_returns_number() {
        String input = "1";
        int result = Calc.Sum(input);
        Assert.assertEquals(1, result);
    }

    @Test
    public void one_and_two_in_input_returns_numbers() {
        String input = "1,2";
        int result = Calc.Sum(input);
        Assert.assertEquals(3, result);
    }

    @Test //2.Metoda add może dodać dowolną ilość liczb
    public void more_than_two_input_returns_numbers() {
        String input = "1,3,4,6";
        Assert.assertEquals(14, Calc.Sum(input));
    }


    @Test //3.1  taki string jest poprawny: "1\n2,3" (suma to 6)
    public void input_with_new_line_returns_sum_of_numbers() {
        String input1 = "1\n2\n3";
        String input2 = "1,2\n3";
        String input3 = "1\n2,3";

        Assert.assertEquals(6, Calc.Sum(input1));
        Assert.assertEquals(6, Calc.Sum(input2));
        Assert.assertEquals(6, Calc.Sum(input3));
    }

  /*  //3.2. taki string nie jest ok: "1,\n" (nie musisz obsługiwać tego przypadku,
    // w tej KATA skupiany się na poprawnych wejściach)
    @Test(expected = InvalidParameterException.class)
    public void ending_newLine_is_invalid_returns_InvalidParameterException(){
        Calc.Sum("1\n");

    }*/

    @Test //2.Metoda add może dodać dowolną ilość liczb
    public void input_with_new_separators_returns_sum_of_numbers() {
        String input = "//;\n1;2";
        Assert.assertEquals(3, Calc.Sum(input));
    }

    @Test
    public void input_negative_returns_negativesNotAllowdedException_and_all_negative_numbers() {
        String input = "-1,2,-3,4";

        exceptedException.expect(InvalidParameterException.class);
        exceptedException.expectMessage("negatives not allowed. Negative numbers: -1 -3");
        Calc.Sum(input);

    }

    @Test
    public void input_more_than_thousand_ignore_value_and_return_sum(){
        String input = "1001,2,3,4";
        Assert.assertEquals(9, Calc.Sum(input));
    }

    @Test
    public void input_with_long_delimiter_and_return_sum(){
        String input = "//[aaa]\n1aaa2aaa3";
        Assert.assertEquals(6, Calc.Sum(input));
    }

    @Test
    public void input_more_than_one_delimiter_and_return_sum(){
        String input = "//[%][a]\n1%2a3";
        Assert.assertEquals(6, Calc.Sum(input));
    }


    @Test
    public void input_more_than_one_delimiter_with_more_than_one_character_return_sum(){
        String input = "//[aaa][opa][vvv][ppp]\n1aaa2opa3ppp2vvv1";
        Assert.assertEquals(9, Calc.Sum(input));
    }


}