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

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}