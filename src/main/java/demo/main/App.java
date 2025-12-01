package demo.main;

import java.util.List;
import java.util.Scanner;

import demo.model.Student;
import demo.service.StudentService;
import demo.service.StudentServiceImple;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static StudentService service = new StudentServiceImple();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Find student");
            System.out.println("3. Find all students");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("6. Exit");
            System.out.println("Enter the option:");
            int option = sc.nextInt();
            switch (option) {
            case 1:
                System.out.println("Enter the id   : ");
                int id = sc.nextInt();
                System.out.println("Enter the name : ");
                String name = sc.next();
                System.out.println("Enter the age  : ");
                int age = sc.nextInt();
                System.out.println("Enter the email: ");
                String email = sc.next();
                Student student = new Student(id, name, age, email);
                System.out.println(service.addStudent(student) ? "Student details added" : "Failed to add student details");
                break;

            case 2:
                System.out.println("Enter the id :");
                id = sc.nextInt();
                student = service.getStudent(id);
                System.out.println(student != null ? student : "Student not found");
                break;
            case 3:
                List<Student> students = service.getAllStudents();
                System.out.println(!students.isEmpty() ? students : "No students found");
                break;
            case 4:
                System.out.println("Enter the id :");
                id = sc.nextInt();
                student = service.getStudent(id);
                if (student != null) {
                    System.out.print("Enter the name :");
                    student.setName(sc.next());
                    System.out.print("Enter the age :");
                    student.setAge(sc.nextInt());
                    System.out.print("Enter the email :");
                    student.setEmail(sc.next());

                    System.out.println(service.updateStudent(student) ? "Student details updated" : "Error");
                } else {
                    System.out.println("Record not found");
                }
                break;
            case 5:
                System.out.println("Enter the id :");
                id = sc.nextInt();
                System.out.println(service.deleteStudent(id) ? "Student record deleted" : "Error ");
                break;
            case 6:
                System.exit(0);
            default:
                break;
            }

        }

    }
}
