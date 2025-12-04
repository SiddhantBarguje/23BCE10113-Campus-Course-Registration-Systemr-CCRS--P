package edu.ccrm.domain;

import java.util.List;

public class Transcript {
    private String studentId;
    private List<Enrollment> enrollments;
    private double gpa;

    private Transcript(Builder builder) {
        this.studentId = builder.studentId;
        this.enrollments = builder.enrollments;
        this.gpa = builder.gpa;
    }

    public String getStudentId() { return studentId; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public double getGpa() { return gpa; }

    public static class Builder {
        private String studentId;
        private List<Enrollment> enrollments;
        private double gpa;

        public Builder studentId(String studentId) { this.studentId = studentId; return this; }
        public Builder enrollments(List<Enrollment> enrollments) { this.enrollments = enrollments; return this; }
        public Builder gpa(double gpa) { this.gpa = gpa; return this; }
        public Transcript build() { return new Transcript(this); }
    }
}
