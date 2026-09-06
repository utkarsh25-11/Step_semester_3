class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class S3v {
    public static void main(String[] args) {
        new EmployeeStatic("Alice", 50000);
        new EmployeeStatic("Bob", 60000);
        new EmployeeStatic("Charlie", 55000);

        EmployeeStatic.printCompanyInfo(); // called via class
    }
}
