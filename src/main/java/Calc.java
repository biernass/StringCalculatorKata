import java.security.InvalidParameterException;

public class Calc {
    public static int Sum(String input) {

        String[] inputAfterSplit = input.split(",|\n|/|;");

        int sum = 0;
        if (input.equals("")) {
            return 0;
        } else {
            for (int i = 0; i < inputAfterSplit.length; i++) {
                if (!inputAfterSplit[i].equals("")) {
                    sum += Integer.parseInt(inputAfterSplit[i]);
                }
            }
        }
        return sum;
    }

}
