package estreraa;

import java.util.Scanner;

public class PayslipSystem {

    private config conf;

 
    public PayslipSystem(config conf) {
        this.conf = conf; 
    }

    PayslipSystem() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void addPayslip() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************");
        System.out.print("Payslip ID: ");
        int payslipId = sc.nextInt();
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Department ID: ");
        int deptId = sc.nextInt();
        System.out.print("Attendance Slip ID: ");
        int attendanceSlipId = sc.nextInt();
        System.out.print("Late Deductions: ");
        double lateDeductions = sc.nextDouble();
        System.out.print("Absent Deductions: ");
        double absentDeductions = sc.nextDouble();
        System.out.print("Loans: ");
        double loans = sc.nextDouble();
        System.out.print("Final Salary: ");
        double finalSalary = sc.nextDouble();
        System.out.println("*******************************");

        String sql = "INSERT INTO Payslip (Payslip_ID, Employee_id, Department_id, AttendanceSlip_id, Late_Deductions, Absent_deductions, Loans, Final_salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, payslipId, empId, deptId, attendanceSlipId, lateDeductions, absentDeductions, loans, finalSalary);
    }

    public void viewPayslips() {
        String qry = "SELECT * FROM Payslip";
        String[] hdrs = {"Payslip ID", "Employee id", "Department ID", "Attendance Slip ID", "Late Deductions", "Absent Deductions", "Loans", "Final Salary"};
        String[] clmn = {"Payslip_ID", "Employee_id", "Department_id", "AttendanceSlip_id", "Late_Deductions", "Absent_deductions", "Loans", "Final_salary"};

        conf.viewRecords(qry, hdrs, clmn);
    }

    public void updatePayslip() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Payslip ID to update: ");
        int payslipId = sc.nextInt();
        System.out.print("New Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("New Department ID: ");
        int deptId = sc.nextInt();
        System.out.print("New Attendance Slip ID: ");
        int attendanceSlipId = sc.nextInt();
        System.out.print("New Late Deductions: ");
        double lateDeductions = sc.nextDouble();
        System.out.print("New Absent Deductions: ");
        double absentDeductions = sc.nextDouble();
        System.out.print("New Loans: ");
        double loans = sc.nextDouble();
        System.out.print("New Final Salary: ");
        double finalSalary = sc.nextDouble();

        String qry = "UPDATE Payslip SET Employee_id = ?, Department_id = ?, AttendanceSlip_id = ?, Late_Deductions = ?, Absent_deductions = ?, Loans = ?, Final_salary = ? WHERE Payslip_ID = ?";
        conf.updateRecord(qry, empId, deptId, attendanceSlipId, lateDeductions, absentDeductions, loans, finalSalary, payslipId);
    }

    public void deletePayslip() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Payslip ID to delete: ");
        int payslipId = sc.nextInt();
        String qry = "DELETE FROM Payslip WHERE Payslip_ID = ?";
        conf.deleteRecord(qry, payslipId);
    }
}