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

    public static String summarizeByModifier(String[][] attempts) {
        int[][] counts = new int[4][2];
        String[] modifiers = {"private", "default", "protected", "public"};

        for (String[] attempt : attempts) {
            String modifier = attempt[0];
            String context = attempt[1];
            String result = classifyAccess(modifier, context);
            
            int modIndex = 0;
            if (modifier.equals("default")) modIndex = 1;
            else if (modifier.equals("protected")) modIndex = 2;
            else if (modifier.equals("public")) modIndex = 3;

            if (result.equals("ALLOWED")) {
                counts[modIndex][0]++;
            } else {
                counts[modIndex][1]++;
            }
        }

        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            summary.append(modifiers[i]).append(": ")
                   .append(counts[i][0]).append(" allowed / ")
                   .append(counts[i][1]).append(" denied\n");
        }
        return summary.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batchAttempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batchAttempts));
    }
}

class LibraryMember {
    private String membershipPin;
    String branchCode;
    String finesOwed;
    public String displayName;
}