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
        EmployeeSystem employeeSystem = new EmployeeSystem(dbConfig, sc);
        AttendanceSystem attendanceSystem = new AttendanceSystem(dbConfig, sc);
        PayslipSystem payslipSystem = new PayslipSystem(dbConfig, sc);
        DepartmentSystem departmentSystem = new DepartmentSystem(dbConfig, sc);

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
                sc.nextLine();
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
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    employeeSystem.addEmployee();
                    break;
                case 2:
                    employeeSystem.viewEmployees();
                    break;
                case 3:
                    employeeSystem.updateEmployee();
                    break;
                case 4:
                    employeeSystem.deleteEmployee();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageAttendance(Scanner sc, AttendanceSystem attendanceSystem) {
        while (true) {
            System.out.println("1. Add Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Update Attendance");
            System.out.println("4. Delete Attendance");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    attendanceSystem.addAttendance();
                    break;
                case 2:
                    attendanceSystem.viewAttendances();
                    break;
                case 3:
                    attendanceSystem.updateAttendance();
                    break;
                case 4:
                    attendanceSystem.deleteAttendance();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void managePayslips(Scanner sc, PayslipSystem payslipSystem) {
        while (true) {
            System.out.println("1. Add Payslip");
            System.out.println("2. View Payslips");
            System.out.println("3. Update Payslip");
            System.out.println("4. Delete Payslip");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    payslipSystem.addPayslip();
                    break;
                case 2:
                    payslipSystem.viewPayslips();
                    break;
                case 3:
                    payslipSystem.updatePayslip();
                    break;
                case 4:
                    payslipSystem.deletePayslip();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageDepartments(Scanner sc, DepartmentSystem departmentSystem) {
        while (true) {
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Update Department");
            System.out.println("4. Delete Department");
            System.out.println("0. Back");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    departmentSystem.addDepartment();
                    break;
                case 2:
                    departmentSystem.viewDepartments();
                    break;
                case 3:
                    departmentSystem.updateDepartment();
                    break;
                case 4:
                    departmentSystem.deleteDepartment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}