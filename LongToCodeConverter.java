public class LongToCodeConverter {
    private static final String ALPHABET = "023456789ABCDEFGHJKLMNPQRSTUVWXY";

    public static String convert(long id) {
        StringBuilder code = new StringBuilder();
        long tempId = id;
        while (tempId > 0) {
            int index = (int) (tempId % ALPHABET.length());
            code.append(ALPHABET.charAt(index));
            tempId /= ALPHABET.length();
        }
        return "X" + code.reverse().toString();
    }

    public static long convertToId(String code) {
        String cleanCode = code.startsWith("X") ? code.substring(1) : code;
        long id = 0;
        for (int i = 0; i < cleanCode.length(); i++) {
            int index = ALPHABET.indexOf(cleanCode.charAt(i));
            if (index == -1) continue;
            id = id * ALPHABET.length() + index;
        }
        return id;
    }
}