import java.security.InvalidParameterException;

public class Calc {
    public static int Sum(String input) {

        String negatives = "";
        String[] inputAfterSplit = input.split(",|\n|/|;");

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                negatives += " -" + input.charAt(i + 1);
            }
        }
        if (negatives.length() > 0) {
            throw new InvalidParameterException("negatives not allowed. Negative numbers:" + negatives);
        }

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
