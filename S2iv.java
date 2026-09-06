public class S2iv {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        if(code.length() >= 3) {
            code = code.substring(0,3).toUpperCase() + code.substring(3);
        }
        return code;
    }

    static String validateAndFormat(String code) {
        if(code.length() != 13) return "Invalid: wrong length";

        for(int i=0;i<3;i++) {
            if(!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        }
        for(int i=3;i<13;i++) {
            if(!Character.isDigit(code.charAt(i)))
                return "Invalid: body must be digits";
        }

        String pub = code.substring(0,3);
        String year = code.substring(3,7);
        String catalog = code.substring(7);
        return "["+pub+"] YEAR: "+year+" | CATALOG: "+catalog;
    }

    public static void main(String[] args) {
        String raw = " pen2026004251 ";
        String code = normalizeCode(raw);
        System.out.println(validateAndFormat(code));

        String bad = "12N2026004251";
        System.out.println(validateAndFormat(normalizeCode(bad)));
    }
}
