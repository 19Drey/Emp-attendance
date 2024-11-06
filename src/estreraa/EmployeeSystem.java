package estreraa;

import java.util.Scanner;

public class EmployeeSystem {
    private config conf; // Reference to your config class
    private Scanner sc; // Single Scanner instance

    // Constructor that initializes the config instance
    public EmployeeSystem(config conf) {
        this.conf = conf; // Assign the provided config instance
        this.sc = new Scanner(System.in); // Initialize the Scanner instance
    }

    public void addEmployee() {
        System.out.println("*******************************");
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("Contact No: ");
        String contactNo = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Status (e.g., Active, Inactive): ");
        String status = sc.nextLine();
        System.out.println("*******************************");

        String sql = "INSERT INTO Employee (emp_id, first_name, last_name, address, contact_no, age, email, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, empId, firstName, lastName, address, contactNo, age, email, status);
        System.out.println("Employee added successfully!");
    }

    public void viewEmployees() {
        String sql = "SELECT * FROM Employee";
        conf.viewRecords(sql);
    }

    public void updateEmployee() {
        System.out.println("*******************************");
        System.out.print("Enter Employee ID to update: ");
        int empId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("New First Name: ");
        String firstName = sc.nextLine();
        System.out.print("New Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("New Address: ");
        String address = sc.nextLine();
        System.out.print("New Contact No: ");
        String contactNo = sc.nextLine();
        System.out.print("New Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("New Email: ");
        String email = sc.nextLine();
        System.out.print("New Status: ");
        String status = sc.nextLine();
        System.out.println("*******************************");

        String sql = "UPDATE Employee SET first_name = ?, last_name = ?, address = ?, contact_no = ?, age = ?, email = ?, status = ? WHERE emp_id = ?";
        conf.updateRecord(sql, firstName, lastName, address, contactNo, age, email, status, empId);
        System.out.println("Employee updated successfully!");
    }

    public void deleteEmployee() {
        System.out.println("*******************************");
        System.out.print("Enter Employee ID to delete: ");
        int empId = sc.nextInt();
        sc.nextLine(); 
        String sql = "DELETE FROM Employee WHERE emp_id = ?";
        conf.deleteRecord(sql, empId);
        System.out.println("Employee deleted successfully!");
    }
}