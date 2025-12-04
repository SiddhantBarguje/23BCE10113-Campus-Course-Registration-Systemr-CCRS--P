package edu.ccrm.service;

import java.util.Scanner;

public class CCRMService {
    private static CCRMService instance;
    private CCRMService() {}
    public static CCRMService getInstance() {
        if (instance == null) {
            synchronized (CCRMService.class) {
                if (instance == null) {
                    instance = new CCRMService();
                }
            }
        }
        return instance;
    }
    // Demo method for primitives, operators, loops, arrays, and string methods
    public void demoFeatures() {
        // Primitive variables and operator precedence
        int a = 5, b = 3;
        int result = a + b * 2; // precedence: b*2 first, then +a
        int bitwise = a & b | 2; // precedence: & before |
        boolean logic = (a > b) && (b < 10) || (a == 5);
        System.out.println("Operator precedence: result=" + result + ", bitwise=" + bitwise + ", logic=" + logic);

        // Decision-making constructs
        if (a > b) {
            System.out.println("a > b");
        } else if (a == b) {
            System.out.println("a == b");
        } else {
            System.out.println("a < b");
        }

        // Nested if-else
        if (a > 0) {
            if (b > 0) {
                System.out.println("Both positive");
            } else {
                System.out.println("a positive, b not");
            }
        }

        // Loops: while, do-while, for, enhanced for, break, continue, labeled jump
        int[] arr = {5, 2, 8, 1};
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i++];
        }
        System.out.println("Sum with while: " + sum);

        i = 0;
        do {
            System.out.println("do-while: arr[" + i + "]=" + arr[i]);
        } while (++i < arr.length);

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 8) continue;
            if (arr[j] == 1) break;
            System.out.println("for: arr[" + j + "]=" + arr[j]);
        }

        outer: for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                if (j == k) continue;
                if (arr[j] + arr[k] == 10) {
                    System.out.println("labeled break: " + arr[j] + "+" + arr[k] + "=10");
                    break outer;
                }
            }
        }

        // Enhanced for loop
        for (int val : arr) {
            System.out.println("enhanced for: " + val);
        }

        // Arrays utility: sort and search
        java.util.Arrays.sort(arr);
        int idx = java.util.Arrays.binarySearch(arr, 5);
        System.out.println("Sorted arr: " + java.util.Arrays.toString(arr) + ", index of 5: " + idx);

        // String methods
        String s = "CCRM,Campus,Manager";
        String[] parts = s.split(",");
        String joined = String.join("-", parts);
        String sub = s.substring(5, 11);
        boolean eq = parts[0].equals("CCRM");
        int cmp = parts[1].compareTo("Campus");
        System.out.println("split: " + java.util.Arrays.toString(parts));
        System.out.println("join: " + joined);
        System.out.println("substring: " + sub);
        System.out.println("equals: " + eq + ", compareTo: " + cmp);
        // Functional interface and lambda: Comparator
        java.util.Comparator<Integer> cmpLambda = (x, y) -> Integer.compare(x, y);
        int cmpResult = cmpLambda.compare(10, 20);
        System.out.println("Lambda Comparator: compare(10,20)=" + cmpResult);

        // Predicate lambda
        java.util.function.Predicate<String> pred = str -> str.length() > 3;
        System.out.println("Predicate test 'abcd': " + pred.test("abcd"));

        // Anonymous inner class example
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous inner class running!");
            }
        };
        r.run();

        // Upcasting, downcasting, instanceof
        edu.ccrm.domain.Person p = new edu.ccrm.domain.Student("S1", "Alice", "alice@x.edu", 18); // upcasting
        System.out.println("Upcasted Person: " + p);
        if (p instanceof edu.ccrm.domain.Student) {
            edu.ccrm.domain.Student studentDown = (edu.ccrm.domain.Student) p; // downcasting
            System.out.println("Downcasted Student: " + studentDown.getName() + ", Max Credits: " + studentDown.getMaxCredits());
        }

        // Method overloading example
        System.out.println("Overloaded sum(int, int): " + sum(2, 3));
        System.out.println("Overloaded sum(double, double): " + sum(2.5, 3.5));

        // Assertions for invariants (enable with -ea JVM flag)
        edu.ccrm.domain.Student demoStudent = new edu.ccrm.domain.Student("S2", "Bob", "bob@x.edu", 21);
        assert demoStudent.getId() != null : "Student ID must not be null";
        assert demoStudent.getMaxCredits() > 0 && demoStudent.getMaxCredits() <= 30 : "Max credits out of bounds";

        // Stream pipeline: GPA distribution report
        java.util.List<edu.ccrm.domain.Enrollment> demoEnrollments = new java.util.ArrayList<>();
        demoEnrollments.add(new edu.ccrm.domain.Enrollment("S2", "C101", edu.ccrm.domain.Semester.FALL));
        demoEnrollments.get(0).setGrade(edu.ccrm.domain.Grade.A);
        demoEnrollments.add(new edu.ccrm.domain.Enrollment("S2", "C102", edu.ccrm.domain.Semester.FALL));
        demoEnrollments.get(1).setGrade(edu.ccrm.domain.Grade.B);
        demoEnrollments.add(new edu.ccrm.domain.Enrollment("S2", "C103", edu.ccrm.domain.Semester.FALL));
        demoEnrollments.get(2).setGrade(edu.ccrm.domain.Grade.A);
        java.util.Map<edu.ccrm.domain.Grade, Long> gpaDist = demoEnrollments.stream()
            .filter(e -> e.getGrade() != null)
            .collect(java.util.stream.Collectors.groupingBy(
                edu.ccrm.domain.Enrollment::getGrade,
                java.util.stream.Collectors.counting()
            ));
        System.out.println("GPA Distribution: " + gpaDist);
    }

    // Method overloading
    public int sum(int a, int b) {
        return a + b;
    }
    public double sum(double a, double b) {
        return a + b;
    }
    // In-memory student store
    private java.util.Map<String, edu.ccrm.domain.Student> students = new java.util.HashMap<>();

    public void studentMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\nStudent Management");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Back");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        if (students.containsKey(id)) {
            System.out.println("Student already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Max Credits: ");
        int maxCredits = scanner.nextInt();
        scanner.nextLine();
        edu.ccrm.domain.Student student = new edu.ccrm.domain.Student(id, name, email, maxCredits);
        students.put(id, student);
        System.out.println("Student added.");
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nStudents:");
        students.values().forEach(s ->
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail() + ", Max Credits: " + s.getMaxCredits())
        );
    }

    private void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        edu.ccrm.domain.Student student = students.get(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter New Name (current: " + student.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter New Email (current: " + student.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter New Max Credits (current: " + student.getMaxCredits() + "): ");
        int maxCredits = scanner.nextInt();
        scanner.nextLine();
        student.setName(name);
        student.setEmail(email);
        student.setMaxCredits(maxCredits);
        System.out.println("Student updated.");
    }

    private void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        if (students.remove(id) != null) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }
    // In-memory course store
    private java.util.Map<String, edu.ccrm.domain.Course> courses = new java.util.HashMap<>();

    public void courseMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\nCourse Management");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Update Course");
            System.out.println("4. Delete Course");
            System.out.println("0. Back");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    updateCourse(scanner);
                    break;
                case 4:
                    deleteCourse(scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addCourse(Scanner scanner) {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();
        if (courses.containsKey(code)) {
            System.out.println("Course already exists.");
            return;
        }
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorId = scanner.nextLine();
        edu.ccrm.domain.Course course = new edu.ccrm.domain.Course.Builder()
            .code(code)
            .title(title)
            .credits(credits)
            .instructorId(instructorId)
            .enrolledStudentIds(new java.util.ArrayList<>())
            .build();
        courses.put(code, course);
        System.out.println("Course added.");
    }

    private void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("\nCourses:");
        courses.values().forEach(c ->
            System.out.println("Code: " + c.getCode() + ", Title: " + c.getTitle() + ", Credits: " + c.getCredits() + ", Instructor ID: " + c.getInstructorId())
        );
    }

    private void updateCourse(Scanner scanner) {
        System.out.print("Enter Course Code to update: ");
        String code = scanner.nextLine();
        edu.ccrm.domain.Course course = courses.get(code);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter New Title (current: " + course.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("Enter New Credits (current: " + course.getCredits() + "): ");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Instructor ID (current: " + course.getInstructorId() + "): ");
        String instructorId = scanner.nextLine();
        edu.ccrm.domain.Course updated = new edu.ccrm.domain.Course.Builder()
            .code(code)
            .title(title)
            .credits(credits)
            .instructorId(instructorId)
            .enrolledStudentIds(course.getEnrolledStudentIds())
            .build();
        courses.put(code, updated);
        System.out.println("Course updated.");
    }

    private void deleteCourse(Scanner scanner) {
        System.out.print("Enter Course Code to delete: ");
        String code = scanner.nextLine();
        if (courses.remove(code) != null) {
            System.out.println("Course deleted.");
        } else {
            System.out.println("Course not found.");
        }
    }
    // In-memory enrollment store
    private java.util.List<edu.ccrm.domain.Enrollment> enrollments = new java.util.ArrayList<>();


    public void enrollMenu(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        edu.ccrm.domain.Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        edu.ccrm.domain.Course course = courses.get(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.print("Enter Semester (SPRING/SUMMER/FALL/WINTER): ");
        String semStr = scanner.nextLine().toUpperCase();
        edu.ccrm.domain.Semester semester;
        try {
            semester = edu.ccrm.domain.Semester.valueOf(semStr);
        } catch (Exception e) {
            System.out.println("Invalid semester.");
            return;
        }
        // Check for duplicate enrollment
        boolean duplicate = enrollments.stream().anyMatch(e -> e.getStudentId().equals(studentId) && e.getCourseCode().equals(courseCode) && e.getSemester() == semester);
        if (duplicate) {
            System.out.println("Error: Student already enrolled in this course for this semester.");
            return;
        }
        // Check max credit limit for semester
        int totalCredits = enrollments.stream()
            .filter(e -> e.getStudentId().equals(studentId) && e.getSemester() == semester)
            .mapToInt(e -> courses.get(e.getCourseCode()).getCredits())
            .sum();
        if (totalCredits + course.getCredits() > student.getMaxCredits()) {
            System.out.println("Error: Max credit limit exceeded for student.");
            return;
        }
        // Enroll
        enrollments.add(new edu.ccrm.domain.Enrollment(studentId, courseCode, semester));
        course.getEnrolledStudentIds().add(studentId);
        System.out.println("Enrollment successful.");
    }
    public void recordMarksMenu(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter Semester (SPRING/SUMMER/FALL/WINTER): ");
        String semStr = scanner.nextLine().toUpperCase();
        edu.ccrm.domain.Semester semester;
        try {
            semester = edu.ccrm.domain.Semester.valueOf(semStr);
        } catch (Exception e) {
            System.out.println("Invalid semester.");
            return;
        }
        edu.ccrm.domain.Enrollment enrollment = enrollments.stream()
            .filter(e -> e.getStudentId().equals(studentId) && e.getCourseCode().equals(courseCode) && e.getSemester() == semester)
            .findFirst().orElse(null);
        if (enrollment == null) {
            System.out.println("Enrollment not found.");
            return;
        }
        System.out.print("Enter Grade (A/B/C/D/F): ");
        String gradeStr = scanner.nextLine().toUpperCase();
        edu.ccrm.domain.Grade grade;
        try {
            grade = edu.ccrm.domain.Grade.valueOf(gradeStr);
        } catch (Exception e) {
            System.out.println("Invalid grade.");
            return;
        }
        enrollment.setGrade(grade);
        System.out.println("Grade recorded.");
    }
    public void transcriptMenu(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        edu.ccrm.domain.Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        java.util.List<edu.ccrm.domain.Enrollment> studentEnrollments = enrollments.stream()
            .filter(e -> e.getStudentId().equals(studentId))
            .collect(java.util.stream.Collectors.toList());
        double gpa = edu.ccrm.util.GPAUtil.calculateGPA(studentEnrollments);
        edu.ccrm.domain.Transcript transcript = new edu.ccrm.domain.Transcript.Builder()
            .studentId(studentId)
            .enrollments(studentEnrollments)
            .gpa(gpa)
            .build();
        System.out.println("\nTranscript for " + student.getName() + " (ID: " + studentId + ")");
        studentEnrollments.forEach(e -> {
            System.out.println("Course: " + e.getCourseCode() + ", Semester: " + e.getSemester() + ", Grade: " + (e.getGrade() != null ? e.getGrade() : "N/A"));
        });
        System.out.printf("GPA: %.2f\n", transcript.getGpa());
    }
    public void importExportMenu(Scanner scanner) {
        System.out.println("1. Export Students to CSV");
        System.out.println("2. Import Students from CSV");
        System.out.println("3. Export Courses to CSV");
        System.out.println("4. Import Courses from CSV");
        System.out.print("Select option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        try {
            switch (choice) {
                case 1:
                    exportStudentsCSV(scanner);
                    break;
                case 2:
                    importStudentsCSV(scanner);
                    break;
                case 3:
                    exportCoursesCSV(scanner);
                    break;
                case 4:
                    importCoursesCSV(scanner);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void exportStudentsCSV(Scanner scanner) throws java.io.IOException {
        System.out.print("Enter file path to export students: ");
        String path = scanner.nextLine();
        java.util.List<String> lines = students.values().stream()
            .map(s -> s.getId() + "," + s.getName() + "," + s.getEmail() + "," + s.getMaxCredits())
            .collect(java.util.stream.Collectors.toList());
        edu.ccrm.io.CSVUtil.writeCSV(path, lines);
        System.out.println("Students exported.");
    }

    private void importStudentsCSV(Scanner scanner) throws java.io.IOException {
        System.out.print("Enter file path to import students: ");
        String path = scanner.nextLine();
        java.util.List<String> lines = edu.ccrm.io.CSVUtil.readCSV(path);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String id = parts[0];
                String name = parts[1];
                String email = parts[2];
                int maxCredits = Integer.parseInt(parts[3]);
                students.put(id, new edu.ccrm.domain.Student(id, name, email, maxCredits));
            }
        }
        System.out.println("Students imported.");
    }

    private void exportCoursesCSV(Scanner scanner) throws java.io.IOException {
        System.out.print("Enter file path to export courses: ");
        String path = scanner.nextLine();
        java.util.List<String> lines = courses.values().stream()
            .map(c -> c.getCode() + "," + c.getTitle() + "," + c.getCredits() + "," + c.getInstructorId())
            .collect(java.util.stream.Collectors.toList());
        edu.ccrm.io.CSVUtil.writeCSV(path, lines);
        System.out.println("Courses exported.");
    }

    private void importCoursesCSV(Scanner scanner) throws java.io.IOException {
        System.out.print("Enter file path to import courses: ");
        String path = scanner.nextLine();
        java.util.List<String> lines = edu.ccrm.io.CSVUtil.readCSV(path);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String code = parts[0];
                String title = parts[1];
                int credits = Integer.parseInt(parts[2]);
                String instructorId = parts[3];
                courses.put(code, new edu.ccrm.domain.Course.Builder()
                    .code(code)
                    .title(title)
                    .credits(credits)
                    .instructorId(instructorId)
                    .enrolledStudentIds(new java.util.ArrayList<>())
                    .build());
            }
        }
        System.out.println("Courses imported.");
    }
    public void backupMenu(Scanner scanner) {
        String sourceDir = System.getProperty("user.dir");
        String backupRoot = edu.ccrm.config.AppConfig.getInstance().getBackupDir();
        try {
            edu.ccrm.util.BackupUtil.backupDirectory(sourceDir, backupRoot);
            System.out.println("Backup completed to folder: " + backupRoot);
        } catch (Exception e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }
}
