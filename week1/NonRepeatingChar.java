public class NonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        int[] frequencies = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequencies[text.charAt(i)]++;
        }
        
        for (int i = 0; i < text.length(); i++) {
            if (frequencies[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        String[] testStrings = {"swiss", "aabbcc"};
        
        for (String text : testStrings) {
            System.out.printf("Input: \"%s\"\n", text);
            char result = findFirstNonRepeatingChar(text);
            
            if (result != 0) {
                System.out.println("Output: First Non-Repeating Character: '" + result + "'\n");
            } else {
                System.out.println("Output: No Non-Repeating Character Found\n");
            }
        }
    }
}