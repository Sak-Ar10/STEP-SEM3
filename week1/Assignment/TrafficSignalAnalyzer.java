public class TrafficSignalAnalyzer {

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) return;

        int maxStreak = 0;
        char maxChar = ' ';
        
        int currentStreak = 1;
        char currentChar = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }
        
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", maxChar, maxStreak);
    }
}