package demo.dao;

import demo.model.Student;
import java.util.List;

public interface StudentDao {
    boolean saveStudent(Student student);
    Student findStudent(int id);
    List<Student> findAllStudents();
    boolean modifyStudent(Student student);
    boolean removeStudent(int id);

}
