public class TypingAccuracyChecker {

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int matchCount = 0;
        int firstMismatch = -1;
        char expectedChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;
                expectedChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = (double) matchCount / original.length() * 100;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%\n", matchCount, original.length(), accuracy);

        if (firstMismatch != -1) {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n", firstMismatch, expectedChar, typedChar);
        } else {
            System.out.println("No Mismatches");
        }
    }
}