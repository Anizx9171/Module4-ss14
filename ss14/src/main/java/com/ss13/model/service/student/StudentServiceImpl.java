package com.ss13.model.service.student;

import com.ss13.model.dao.student.StudentDAOImpl;
import com.ss13.model.entity.Student;
import com.ss13.model.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    StudentDAOImpl studentDAO;
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> findPagi(Integer noPage) {
        return studentDAO.findPagi(noPage);
    }

    @Override
    public void add(Student student) {
        studentDAO.add(student);
    }

    @Override
    public void remove(Integer integer) {
        studentDAO.remove(integer);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }

    @Override
    public Student findById(Integer integer) {
        return studentDAO.findById(integer);
    }
}
