package demo.dao;

import demo.model.Student;
import demo.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImple implements StudentDao {

    @Override
    public boolean saveStudent(Student student) {
        String query = "insert into student (id, name, age, email) values(?,?,?,?)";
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getEmail());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student findStudent(int id) {
        String query = "select * from student where id = ?";
        Student student = null;
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        String query = "select * from student";
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean modifyStudent(Student student) {
        String query = "update student set name = ?, age = ?, email = ? where id = ?";
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());
            statement.setInt(4, student.getId());
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeStudent(int id) {
        String query = "delete from student where id = ?";
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}

