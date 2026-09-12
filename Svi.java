// LibraryMember class with correct access modifiers
class LibraryMember {
    private String membershipPin;   // only LibraryMember itself
    String branchCode;              // default → same package only
    protected double finesOwed;     // same package (subclass rules in Problem 2)
    public String displayName;      // accessible everywhere
}

// AccessChecker utility
public class Svi {

    // Single attempt classifier
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch(fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected":
                return (accessorContext.equals("SAME_PACKAGE") || accessorContext.equals("SAME_CLASS"))
                        ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    // Summarizer grouped by modifier
    public static String summarizeByModifier(String[][] attempts) {
        int privAllowed=0, privDenied=0;
        int defAllowed=0, defDenied=0;
        int protAllowed=0, protDenied=0;
        int pubAllowed=0, pubDenied=0;

        for (int i = 0; i < attempts.length; i++) {
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(modifier, context);

            switch(modifier) {
                case "private":
                    if(result.equals("ALLOWED")) privAllowed++; else privDenied++;
                    break;
                case "default":
                    if(result.equals("ALLOWED")) defAllowed++; else defDenied++;
                    break;
                case "protected":
                    if(result.equals("ALLOWED")) protAllowed++; else protDenied++;
                    break;
                case "public":
                    if(result.equals("ALLOWED")) pubAllowed++; else pubDenied++;
                    break;
            }
        }

        return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
               "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
               "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
               "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }

    // Demo main
    public static void main(String[] args) {
        String[][] attempts = {
            {"private","SAME_CLASS"}, {"private","SAME_PACKAGE"},
            {"default","SAME_PACKAGE"}, {"default","DIFFERENT_PACKAGE"},
            {"protected","SAME_PACKAGE"}, {"protected","SAME_CLASS"},
            {"public","DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeByModifier(attempts));
    }
}
