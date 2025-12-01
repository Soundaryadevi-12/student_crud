package demo.service;
import java.util.List;
import demo.model.Student;

public interface StudentService {
    boolean addStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);

}
