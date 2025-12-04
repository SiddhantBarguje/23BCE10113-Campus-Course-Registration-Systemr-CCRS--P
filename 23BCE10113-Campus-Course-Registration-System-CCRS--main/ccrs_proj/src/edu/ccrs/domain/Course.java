package edu.ccrm.domain;

import java.util.List;

public class Course {
    private String code;
    private String title;
    private int credits;
    private String instructorId;
    private List<String> enrolledStudentIds;

    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructorId = builder.instructorId;
        this.enrolledStudentIds = builder.enrolledStudentIds;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructorId() { return instructorId; }
    public List<String> getEnrolledStudentIds() { return enrolledStudentIds; }

    public static class Builder {
        private String code;
        private String title;
        private int credits;
        private String instructorId;
        private List<String> enrolledStudentIds;

        public Builder code(String code) { this.code = code; return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder credits(int credits) { this.credits = credits; return this; }
        public Builder instructorId(String instructorId) { this.instructorId = instructorId; return this; }
        public Builder enrolledStudentIds(List<String> ids) { this.enrolledStudentIds = ids; return this; }
        public Course build() { return new Course(this); }
    }

    // Static nested class example
    public static class CourseStats {
        public static int countEnrolled(Course course) {
            return course.enrolledStudentIds.size();
        }
    }

    // Inner class example
    public class CourseInfo {
        public String getSummary() {
            return "Course: " + code + ", Title: " + title + ", Credits: " + credits;
        }
    }
}
