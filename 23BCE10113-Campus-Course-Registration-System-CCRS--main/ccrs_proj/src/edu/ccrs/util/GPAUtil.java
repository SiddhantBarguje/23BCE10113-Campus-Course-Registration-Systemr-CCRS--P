package edu.ccrm.util;

import java.util.Comparator;

public class GPAUtil {
    public static double calculateGPA(java.util.List<edu.ccrm.domain.Enrollment> enrollments) {
        double totalPoints = enrollments.stream()
            .filter(e -> e.getGrade() != null)
            .mapToDouble(e -> e.getGrade().getPoints() * 1)
            .sum();
        long count = enrollments.stream().filter(e -> e.getGrade() != null).count();
        return count == 0 ? 0.0 : totalPoints / count;
    }
}
