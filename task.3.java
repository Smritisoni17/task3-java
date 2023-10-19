
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PasswordStrengthIndicator {

    public static void main(String[] args) {
        String password = "YourPassword123!"; // Replace this with the actual password entered by the user

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = hasSpecialCharacter(password);

        int score = calculatePasswordStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);
        String strength = getPasswordStrengthLabel(score);

        System.out.println("Password Strength: " + strength);
    }

    private static int calculatePasswordStrength(int length, boolean hasUppercase, boolean hasLowercase,
            boolean hasDigit, boolean hasSpecialChar) {
        int score = 0;

        if (length >= 8) {
            score += 3;
        } else if (length >= 6) {
            score += 2;
        } else {
            score += 1;
        }

        if (hasUppercase) {
            score++;
        }

        if (hasLowercase) {
            score++;
        }

        if (hasDigit) {
            score++;
        }

        if (hasSpecialChar) {
            score++;
        }

        return score;
    }

    private static String getPasswordStrengthLabel(int score) {
        if (score >= 6) {
            return "Strong";
        } else if (score >= 4) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    private static boolean hasSpecialCharacter(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
