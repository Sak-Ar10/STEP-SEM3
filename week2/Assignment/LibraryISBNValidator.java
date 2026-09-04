public class LibraryISBNValidator {
    public String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code.substring(0, 3)).append("] ")
                 .append("YEAR: ").append(code.substring(3, 7)).append(" | ")
                 .append("CATALOG: ").append(code.substring(7));
                 
        return formatted.toString();
    }
}