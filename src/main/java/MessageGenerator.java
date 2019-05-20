public class MessageGenerator {
    //function for correct time presentation (to format 1 hour and 1 minute to 01:01)
    public static String formatNumber(int number) {

        String result;

        if (number < 10) {
            result = "0" + number;
        } else {
            result = String.valueOf(number);
        }

        return result;
    }
}
