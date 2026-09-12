public class AccessCheckerP2 {

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
        if ("protected".equals(fieldModifier) && "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            if ("DENIED".equals(classifyAccess(modifier, context))) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] test1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(test1));

        String[][] test2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(test2));
    }
}