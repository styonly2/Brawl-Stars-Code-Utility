import java.awt.Toolkit;

public class IDUtils {

    public static boolean checkPattern(String code) {
        // Look for 3 repeating chars (e.g. JJJ) or 777
        return checkRepeatingChars(code) || code.contains("777");
    }

    private static boolean checkRepeatingChars(String code) {
        for (int i = 0; i < code.length() - 2; i++) {
            if (code.charAt(i) == code.charAt(i+1) && code.charAt(i) == code.charAt(i+2)) {
                return true;
            }
        }
        return false;
    }

    public static String getPatternDescription(String code) {
        if (code.contains("777")) return "JACKPOT: 777 FOUND!";
        if (checkRepeatingChars(code)) return "TRIPLE CHARS DETECTED";
        return "RARE PATTERN";
    }

    public static void playRareSound() {
        Toolkit.getDefaultToolkit().beep();
    }
}