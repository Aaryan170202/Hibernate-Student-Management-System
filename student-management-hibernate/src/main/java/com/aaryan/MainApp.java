package com.aaryan;


import java.util.List;
import java.util.Scanner;
import com.aaryan.dao.StudentDao;
import com.aaryan.model.Student;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDao dao = new StudentDao();
        int choice;

        do {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Create Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Show Students by Id");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    Student student = new Student(name, email, course);
                    dao.saveStudent(student);
                    System.out.println("Student created successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(updateId, newName, newEmail, newCourse);
                    System.out.println("Student updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully!");
                    break;

                case 4:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter student ID: ");
                    int getId = sc.nextInt();
                    Student s = dao.getStudent(getId);
                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        } while (choice != 6);

        sc.close();
    }
}
