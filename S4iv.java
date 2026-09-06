class MembershipCard {
    static String libraryName;
    static String validUntil;
    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    MembershipCard(String studentName) {
        this.studentName = studentName;
    }
}

public class S4iv {
    public static void main(String[] args) {
        String[] names = {"Ananya","Rohan","Priya","Arjun","Sneha"};

        for(String n : names) {
            MembershipCard card = new MembershipCard(n);
            System.out.println("Membership card issued: " + card.studentName);
        }
    }
}
