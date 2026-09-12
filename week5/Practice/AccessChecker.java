public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }
        if ("SAME_CLASS".equals(accessorContext)) {
            return "ALLOWED";
        }
        if ("private".equals(fieldModifier)) {
            return "DENIED";
        }
        if ("SAME_PACKAGE".equals(accessorContext)) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowedCount = 0;
        int deniedCount = 0;
        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);
            if ("ALLOWED".equals(result)) {
                allowedCount++;
            } else {
                deniedCount++;
            }
        }
        return "Allowed: " + allowedCount + "\nDenied: " + deniedCount;
    }
    public static void main(String[] args) {
        System.out.println("Test 1: " + classifyAccess("private", "SAME_CLASS")); 
        
        System.out.println("Test 2: " + classifyAccess("protected", "DIFFERENT_PACKAGE")); 

        String[][] batchAttempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("Test 3 Batch Summary:\n" + summarizeBatch(batchAttempts));
    }
}

class MovieTicket {
    private String seatNumber;
    int screenId; 
    protected double ticketPrice;
    public String movieTitle;
}