package estreraa;

import java.util.Scanner;

public class AttendanceSystem {

    AttendanceSystem(config conf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    AttendanceSystem() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    public void addAttendance() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

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

    // Method to view all attendance records
    public void viewAttendances() {
        config conf = new config();
        String qry = "SELECT * FROM Attendanceslip";
        String[] hdrs = {"Attendance ID", "Employee ID", "Department ID", "Working Days", "Late Days", "Absences", "Loan"};
        String[] clmn = {"Attendanceslip_ID", "emp_id", "Department_id", "No_of_Working_Days", "No_of_Late_Days", "No_of_Absences", "Loan"};

        conf.viewRecords(qry, hdrs, clmn);
    }


    public void updateAttendance() {
        Scanner sc = new Scanner(System.in);

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

        config conf = new config();
        conf.updateRecord(qry, empId, deptId, workingDays, lateDays, absences, loan, attendanceId);
    }

    public void deleteAttendance() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Attendance ID to delete: ");
        int attendanceId = sc.nextInt();

        String qry = "DELETE FROM Attendanceslip WHERE Attendanceslip_ID = ?";

        config conf = new config();
        conf.deleteRecord(qry, attendanceId);
    }
}
