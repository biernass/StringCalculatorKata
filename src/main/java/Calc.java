import java.security.InvalidParameterException;
import java.util.Arrays;

public class Calc {
    public static int Sum(String input) {


        int sum = 0;
        int countOfDelimiter = 0;


        if (input.equals("")) {
            return 0;
        } else if (input.startsWith("//")) {
            /*for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '[' || input.charAt(i) == ']') {
                    countOfDelimiter++;
                } else if (countOfDelimiter % 2 != 0) {
                    countOfDelimiter--;
                }
            }*/

            int customSeparatorStartPosition = input.indexOf("//") + "//".length();
            int customSeparatorEndPosition = input.indexOf("\\n");
            String customSeparatorsDefinition = input.substring(customSeparatorStartPosition, customSeparatorEndPosition);

            if(customSeparatorsDefinition.startsWith("[") && customSeparatorsDefinition.endsWith("]")){
                String customSeparatorsWhithoutFirstAndLastBracket = customSeparatorsDefinition.substring(1,
                        customSeparatorsDefinition.length() - 1);
                String customSeparators = customSeparatorsWhithoutFirstAndLastBracket.replace("][", "|");

                String newInput = input.substring(customSeparatorEndPosition + 2, input.length());
                String[] characters = newInput.split(",|\n|" + customSeparators);

                for (int i = 0; i < characters.length; i++) {
                    if (Integer.parseInt(characters[i]) <= 1000) {
                        sum += Integer.parseInt(characters[i]);
                    }
                }


                return sum;
            }


            char customSeparator = input.charAt(2);
            String newInput = input.substring(4);
            String[] characters = newInput.split(",|\n|" + customSeparator);

            for (int i = 0; i < characters.length; i++) {
                if (Integer.parseInt(characters[i]) <= 1000) {
                    sum += Integer.parseInt(characters[i]);
                }
            }
            return sum;

        } else {
            String[] inputAfterSplit = input.split(",|\n|;");
            String negatives = "";

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '-') {
                    negatives += " -" + input.charAt(i + 1);
                }
            }
            if (negatives.length() > 0) {
                throw new InvalidParameterException("negatives not allowed. Negative numbers:" + negatives);
            } else {
                for (int i = 0; i < inputAfterSplit.length; i++) {
                    if (!inputAfterSplit[i].equals("")) {
                        if (Integer.parseInt(inputAfterSplit[i]) <= 1000) {
                            sum += Integer.parseInt(inputAfterSplit[i]);
                        }
                    }
                }
            }
            return sum;
        }
    }

}
