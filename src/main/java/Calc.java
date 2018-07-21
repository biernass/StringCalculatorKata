public class Calc {
    public static int Sum(String input) {
        String[] inputAfterSplit = input.split(",");

        if(input.equals("")) {
            return 0;
        }
        else {
            int sum = 0;
            for(int i = 0; i < inputAfterSplit.length; i++){
            sum += Integer.parseInt(inputAfterSplit[i]);
            }
            return sum;
        }

    }
}