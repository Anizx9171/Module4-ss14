package com.ss13.model.dao.student;

import com.ss13.model.dao.student.IStudentDAO;
import com.ss13.model.entity.Student;
import com.ss13.utils.ConnectionDB;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOImpl implements IStudentDAO {
    @Override
    public List<Student> findAll(){
        Connection c = null;
        List<Student> students = new ArrayList<>();
        try {
            c = ConnectionDB.openConnection();
            c.setAutoCommit(false);
            CallableStatement cs = c.prepareCall("{CALL FIND_ALL_STUDENT}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setAddress(rs.getString("address"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthdate(rs.getDate("birthdate"));
                students.add(student);
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(c);
        }
        return students;
    }

    @Override
    public List<Student> findPagi(Integer noPage) {
        return null;
    }

    @Override
    public void add(Student student) {
        Connection c = null;
        c = ConnectionDB.openConnection();
        try {
            c.setAutoCommit(false);
            CallableStatement cs = c.prepareCall("{CALL ADD_STUDENT(?,?,?,?)}");
            cs.setString(1, student.getName());
            cs.setString(2, student.getAddress());
            cs.setDate(3, student.getBirthdate());
            cs.setBoolean(4, student.isSex());
            int countUpdate = cs.executeUpdate();
            if (countUpdate > 0){
                c.commit();
            }else{
                c.rollback();
            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(c);
        }
    }

    @Override
    public void remove(Integer integer) {
        Connection c = null;
        c = ConnectionDB.openConnection();
        try {
            CallableStatement cs = c.prepareCall("{CALL DELETE_STUDENT(?)}");
            cs.setInt(1, integer);
            cs.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(c);
        }
    }

    @Override
    public void update(Student student) {
        Connection c = null;
        c = ConnectionDB.openConnection();
        try {
            CallableStatement cs = c.prepareCall("{CALL UPDATE_STUDENT(?,?,?,?,?)}");
            cs.setInt(1, student.getId());
            cs.setString(2, student.getName());
            cs.setString(3, student.getAddress());
            cs.setDate(4, student.getBirthdate());
            cs.setBoolean(5, student.isSex());
            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(c);
        }
    }

    @Override
    public Student findById(Integer integer) {
        Connection c = null;
        Student student = null;
        try {
            c = ConnectionDB.openConnection();
            c.setAutoCommit(false);
            CallableStatement cs = c.prepareCall("{CALL FIND_BY_ID_STUDENT(?)}");
            cs.setInt(1, integer);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setAddress(rs.getString("address"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getBoolean("sex"));
                student.setBirthdate(rs.getDate("birthdate"));
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(c);
        }
        return student;
    }
}
