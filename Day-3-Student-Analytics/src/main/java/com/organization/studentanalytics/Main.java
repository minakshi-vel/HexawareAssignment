package com.organization.studentanalytics;

import com.organization.studentanalytics.model.Student;
import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface StudentFilter {
    boolean test(Student s);
}

public class Main {
    public static void main(String[] args) {
        // 1. Store all students in a List implementation
        List<Student> students = Arrays.asList(
            new Student(101, "Anu", "Java", 82, true),  new Student(102, "Bala", "Java", 45, false),
            new Student(103, "Charan", "Python", 91, true), new Student(104, "Divya", "Java", 67, true),
            new Student(105, "Esha", "Python", 38, false), new Student(106, "Farhan", "DevOps", 74, true),
            new Student(107, "Gokul", "DevOps", 88, true), new Student(108, "Hari", "Java", 53, true),
            new Student(109, "Isha", "Python", 79, true),  new Student(110, "John", "DevOps", 62, true),
            new Student(111, "Kavya", "Java", 95, true), new Student(112, "Lokesh", "Python", 49, false)
        );

        // 2. Unique courses (Set)
        System.out.println("Unique Courses (Set)\n" + students.stream().map(Student::getCourse).collect(Collectors.toCollection(LinkedHashSet::new)) + "\n");

        // 3. Group students by course (Map)
        System.out.println("Students Grouped by Course (Map)");
        students.stream().collect(Collectors.groupingBy(Student::getCourse)).forEach((k, v) -> System.out.println(k + " → " + v));
        System.out.println();

        // 4. Filter all passed students using Streams + Lambda
        System.out.println("Passed Students (Filtered)");
        List<Student> passed = students.stream().filter(s -> s.isPassed()).collect(Collectors.toList());
        System.out.println(passed.stream().map(Student::getStudentName).collect(Collectors.joining(", ")) + "\n");

        // 5. Statistics
        System.out.println("Total Marks of Passed Students\n" + passed.stream().mapToInt(Student::getMarks).sum() + "\n");
        System.out.printf(Locale.US, "Average Marks of Passed Students\n%.1f\n\n", passed.stream().mapToInt(Student::getMarks).average().orElse(0));
        System.out.print("Highest Marks Scorer\n");
        passed.stream().max(Comparator.comparingInt(Student::getMarks)).ifPresent(s -> System.out.println(s.getStudentName() + " – " + s.getMarks() + "\n"));

        // 6. Sort passed students (Marks Descending, Name Ascending)
        System.out.println("Sorted Passed Students (Marks ↓, Name ↑)");
        List<Student> sortedPassed = passed.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed().thenComparing(Student::getStudentName))
                .collect(Collectors.toList());
        sortedPassed.forEach(s -> System.out.println(s.toDetailString()));
        System.out.println();

        // 7. Course-wise total marks report
        System.out.println("Course-wise Total Marks (Map)");
        Map<String, Integer> courseWiseMarks = students.stream().collect(Collectors.groupingBy(Student::getCourse, Collectors.summingInt(Student::getMarks)));
        Arrays.asList("Java", "Python", "DevOps").forEach(c -> System.out.println(c + " → " + courseWiseMarks.get(c)));
        System.out.println();

        // 8. Optional Search Result
        System.out.println("Optional Search Result (studentId = 110)");
        students.stream().filter(s -> s.getStudentId() == 110).findFirst()
                .ifPresentOrElse(s -> System.out.println("Student found: " + s.getStudentName() + " – " + s.getCourse() + " – " + s.getMarks() + "\n"), 
                                 () -> System.out.println("Student not found\n"));

        // 9. Functional interface to filter marks >= 75
        System.out.println("Students with Marks ≥ 75 (Functional Interface Filter)");
        StudentFilter filter75 = s -> s.getMarks() >= 75;
        students.stream().filter(filter75::test).forEach(s -> System.out.println(s.toDetailString()));
        System.out.println();

        // 10. Method reference print
        System.out.println("Final Report Printed Using Method Reference");
        sortedPassed.stream().map(Student::toDetailString).forEach(System.out::println);
    }
}