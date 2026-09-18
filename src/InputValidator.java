public class InputValidator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isPositiveInteger(String input) {

        try {
            int number = Integer.parseInt(input);

            return number > 0;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {

        if (isEmpty(email)) {
            return false;
        }

        return email.contains("@") && email.contains(".");
    }

    public static int parsePositiveInteger(String input) {

        try {
            int number = Integer.parseInt(input);

            if (number > 0) {
                return number;
            }

        } catch (NumberFormatException e) {
            // Invalid input
        }

        return -1;
    }
}
