package estreraa;

import java.util.Scanner;

public class DepartmentSystem {
    private config conf;
    private Scanner sc;

    public DepartmentSystem(config conf, Scanner sc) {
        this.conf = conf;
        this.sc = sc;
    }

    public void addDepartment() {
        System.out.println("*******************************");
        System.out.print("Department ID: ");
        int deptId = sc.nextInt();
        sc.nextLine();
        System.out.print("Department Name: ");
        String deptName = sc.nextLine();
        System.out.print("Department Head: ");
        String deptHead = sc.nextLine();
        System.out.print("Contact Information: ");
        String contactInfo = sc.nextLine();
        System.out.print("Location: ");
        String location = sc.nextLine();
        System.out.print("Basic Salary: ");
        int basicSalary = sc.nextInt();
        System.out.print("Late Deduction: ");
        int lateDeduction = sc.nextInt();
        System.out.print("Absent Deduction: ");
        int absentDeduction = sc.nextInt();
        System.out.println("*******************************");

        String sql = "INSERT INTO Department (dept_id, dept_name, Department_Head, Contact_information, Location, Basic_salary, Late_Deduction, Absent_deduction) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, deptId, deptName, deptHead, contactInfo, location, basicSalary, lateDeduction, absentDeduction);
    }

    public void viewDepartments() {
        String qry = "SELECT * FROM Department";
        conf.viewRecords(qry);
    }

    public void updateDepartment() {
        System.out.print("Enter Department ID to update: ");
        int deptId = sc.nextInt();
        sc.nextLine();
        System.out.print("New Department Name: ");
        String deptName = sc.nextLine();
        System.out.print("New Department Head: ");
        String deptHead = sc.nextLine();
        System.out.print("New Contact Information: ");
        String contactInfo = sc.nextLine();
        System.out.print("New Location: ");
        String location = sc.nextLine();
        System.out.print("New Basic Salary: ");
        int basicSalary = sc.nextInt();
        System.out.print("New Late Deduction: ");
        int lateDeduction = sc.nextInt();
        System.out.print("New Absent Deduction: ");
        int absentDeduction = sc.nextInt();

        String qry = "UPDATE Department SET dept_name = ?, Department_Head = ?, Contact_information = ?, Location = ?, Basic_salary = ?, Late_Deduction = ?, Absent_deduction = ? WHERE dept_id = ?";
        conf.updateRecord(qry, deptName, deptHead, contactInfo, location, basicSalary, lateDeduction, absentDeduction, deptId);
    }

    public void deleteDepartment() {
        System.out.print("Enter Department ID to delete: ");
        int deptId = sc.nextInt();
        String qry = "DELETE FROM Department WHERE dept_id = ?";
        conf.deleteRecord(qry, deptId);
    }
}