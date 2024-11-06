package estreraa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSystem {

   private static final String USERNAME = "hr";
   private static final String PASSWORD = "password";

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       if (!login(sc)) {
           System.out.println("Too many failed attempts. Exiting.");
           return;
       }

       config dbConfig = new config();
       EmployeeSystem employeeSystem = new EmployeeSystem(dbConfig); 
       AttendanceSystem attendanceSystem = new AttendanceSystem();
       PayslipSystem payslipSystem = new PayslipSystem();
       DepartmentSystem departmentSystem = new DepartmentSystem();

       while (true) {
           try {
               System.out.println("*******************************");
               System.out.println("1. Manage Employees");
               System.out.println("2. Manage Attendance");
               System.out.println("3. Manage Payslips");
               System.out.println("4. Manage Departments");
               System.out.println("0. Exit");
               System.out.println("*******************************");
               System.out.print("Select an option: ");
               int choice = sc.nextInt();
               sc.nextLine();

               switch (choice) {
                   case 1:
                       manageEmployees(sc, employeeSystem);
                       break;
                   case 2:
                       manageAttendance(sc, attendanceSystem);
                       break;
                   case 3:
                       managePayslips(sc, payslipSystem);
                       break;
                   case 4:
                       manageDepartments(sc, departmentSystem);
                       break;
                   case 0:
                       System.out.println("Have a nice day!!");
                       return;
                   default:
                       System.out.println("Invalid option. Please try again.");
               }
           } catch (InputMismatchException e) {
               System.out.println("Invalid input. Please enter a number.");
               sc.nextLine(); // Clear buffer
           }
       }
   }

   private static boolean login(Scanner sc) {
       int attempts = 0;
       while (attempts < 3) {
           System.out.print("Enter username: ");
           String username = sc.nextLine();
           System.out.print("Enter password: ");
           String password = sc.nextLine();

           if (USERNAME.equals(username) && PASSWORD.equals(password)) {
               System.out.println("Login successful!");
               return true;
           } else {
               System.out.println("Incorrect username or password.");
               attempts++;
           }
       }
       return false;
   }

   public static void manageEmployees(Scanner sc, EmployeeSystem employeeSystem) {
       // Implementation remains unchanged
   }

   public static void manageAttendance(Scanner sc, AttendanceSystem attendanceSystem) {
       // Implementation remains unchanged
   }

   public static void managePayslips(Scanner sc, PayslipSystem payslipSystem) {
       // Implementation remains unchanged
   }

   public static void manageDepartments(Scanner sc, DepartmentSystem departmentSystem) {
       // Implementation remains unchanged
   }
}