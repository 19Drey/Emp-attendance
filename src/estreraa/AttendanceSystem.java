package estreraa;

import java.util.Scanner;

public class AttendanceSystem {
    private config conf;
    private Scanner sc;

    public AttendanceSystem(config conf, Scanner sc) {
        this.conf = conf;
        this.sc = sc;
    }

    public void addAttendance() {
        System.out.println("*******************************");
        System.out.print("Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Department ID: ");
        int deptId = sc.nextInt();
        System.out.print("Number of Working Days: ");
        int workingDays = sc.nextInt();
        System.out.print("Number of Late Days: ");
        int lateDays = sc.nextInt();
        System.out.print("Number of Absences: ");
        int absences = sc.nextInt();
        System.out.print("Loan Amount: ");
        double loan = sc.nextDouble();
        System.out.println("*******************************");

        String sql = "INSERT INTO Attendanceslip (emp_id, Department_id, No_of_Working_Days, No_of_Late_Days, No_of_Absences, Loan) VALUES (?, ?, ?, ?, ?, ?)";
        conf.addRecord(sql, empId, deptId, workingDays, lateDays, absences, loan);
    }

    public void viewAttendances() {
        String qry = "SELECT * FROM Attendanceslip";
        conf.viewRecords(qry);
    }

    public void updateAttendance() {
        System.out.print("Enter Attendance ID to update: ");
        int attendanceId = sc.nextInt();
        System.out.print("New Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("New Department ID: ");
        int deptId = sc.nextInt();
        System.out.print("New Number of Working Days: ");
        int workingDays = sc.nextInt();
        System.out.print("New Number of Late Days: ");
        int lateDays = sc.nextInt();
        System.out.print("New Number of Absences: ");
        int absences = sc.nextInt();
        System.out.print("New Loan Amount: ");
        double loan = sc.nextDouble();

        String qry = "UPDATE Attendanceslip SET emp_id = ?, Department_id = ?, No_of_Working_Days = ?, No_of_Late_Days = ?, No_of_Absences = ?, Loan = ? WHERE Attendanceslip_ID = ?";
        conf.updateRecord(qry, empId, deptId, workingDays, lateDays, absences, loan, attendanceId);
    }

    public void deleteAttendance() {
        System.out.print("Enter Attendance ID to delete: ");
        int attendanceId = sc.nextInt();
        String qry = "DELETE FROM Attendanceslip WHERE Attendanceslip_ID = ?";
        conf.deleteRecord(qry, attendanceId);
    }
}