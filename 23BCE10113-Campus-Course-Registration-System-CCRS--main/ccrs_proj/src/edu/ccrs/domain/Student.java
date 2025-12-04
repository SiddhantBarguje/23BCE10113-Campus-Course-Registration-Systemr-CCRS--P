package edu.ccrm.domain;

public class Student extends Person {
    private int maxCredits;
    public Student(String id, String name, String email, int maxCredits) {
        super(id, name, email);
        this.maxCredits = maxCredits;
    }
    public int getMaxCredits() { return maxCredits; }
    public void setMaxCredits(int maxCredits) { this.maxCredits = maxCredits; }

    @Override
    public String getRole() {
        return "Student";
    }
}
