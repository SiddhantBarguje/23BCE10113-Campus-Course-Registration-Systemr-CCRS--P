package edu.ccrm.domain;

public class Enrollment {
    private String studentId;
    private String courseCode;
    private Semester semester;
    private Grade grade;

    public Enrollment(String studentId, String courseCode, Semester semester) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public Semester getSemester() { return semester; }
    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}
