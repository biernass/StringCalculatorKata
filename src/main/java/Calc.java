import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Calc {
    public static int Sum(String input) {
        int sum = 0;
        String customSeparators;
        String newInput;
        if (input.equals("")) {
            return 0;
        }
        if (input.startsWith("//")) {

            customSeparators = getCustomSeparator(input);
            input = getInputNumbers(input);
        } else {
            customSeparators = ",|\n";
        }
        String[] characters = input.split(customSeparators);
        throwIfNegativeNumbersOccurs(characters);

        return sumOfCharacters(characters);
    }

    private static int sumOfCharacters(String[] characters) {
        int sum = 0;

        for (String character : characters) {
            if (!character.equals("")) {
                if (Integer.parseInt(character) <= 1000) {
                    sum += Integer.parseInt(character);
                }
            }
        }
        return sum;
    }

    private static String getCustomSeparator(String input) {
        String customSeparators = "";
        int customSeparatorStartPosition = input.indexOf("//") + "//".length();
        int customSeparatorEndPosition = input.indexOf("\n");
        String customSeparatorsDefinition = input.substring(customSeparatorStartPosition, customSeparatorEndPosition);

        if (customSeparatorsDefinition.startsWith("[") && customSeparatorsDefinition.endsWith("]")) {
            String customSeparatorsWhithoutFirstAndLastBracket = customSeparatorsDefinition.substring(1,
                    customSeparatorsDefinition.length() - 1);
            return customSeparators = customSeparatorsWhithoutFirstAndLastBracket.replace("][", "|");

        }
        return customSeparatorsDefinition;
    }

    private static String getInputNumbers(String input) {

        int customSeparatorEndPosition = input.indexOf("\n");

        return input.substring(customSeparatorEndPosition + "\n".length());

    }

    private static void throwIfNegativeNumbersOccurs(String[] characters) {
        String negatives = "";

        for (int i = 0; i < characters.length; i++) {
            if (characters[i].contains("-")) {
                negatives += " " + characters[i];
            }
        }
        if (negatives.length() > 0) {
            throw new InvalidParameterException("negatives not allowed. Negative numbers:" + negatives);
        }
    }
}


