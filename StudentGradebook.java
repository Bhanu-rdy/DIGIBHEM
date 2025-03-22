import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    ArrayList<Integer> grades = new ArrayList<>();

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + " (ID: " + id + "): " + grades);
        System.out.println("Average Grade: " + getAverageGrade());
    }
}

public class StudentGradebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Gradebook Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grades");
            System.out.println("3. View Student Grades");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    students.add(new Student(name, id));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID to add grades: ");
                    int studentId = scanner.nextInt();
                    Student student = findStudentById(students, studentId);
                    if (student != null) {
                        System.out.print("Enter grade to add: ");
                        int grade = scanner.nextInt();
                        student.addGrade(grade);
                        System.out.println("Grade added successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to view grades: ");
                    int viewId = scanner.nextInt();
                    Student viewStudent = findStudentById(students, viewId);
                    if (viewStudent != null) {
                        viewStudent.displayGrades();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    Student removeStudent = findStudentById(students, removeId);
                    if (removeStudent != null) {
                        students.remove(removeStudent);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static Student findStudentById(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }
}
