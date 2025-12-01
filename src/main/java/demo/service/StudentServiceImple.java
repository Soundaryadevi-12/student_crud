package demo.service;
import java.util.List;
import demo.dao.StudentDao;  
import demo.dao.StudentDaoImple;
import demo.model.Student;

public class StudentServiceImple implements StudentService {

    private StudentDao dao=new StudentDaoImple();   

    public boolean addStudent(Student student) {
        return dao.saveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return dao.findStudent(id);
    }
    @Override
    public List<Student> getAllStudents(){
        return dao.findAllStudents();
    }
    @Override
    public boolean updateStudent(Student student){
        return dao.modifyStudent(student);
    }

    @Override
    public boolean deleteStudent(int id){
        return dao.removeStudent(id);
    }

}
