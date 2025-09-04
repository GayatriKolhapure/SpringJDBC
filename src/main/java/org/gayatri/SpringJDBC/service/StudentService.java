package org.gayatri.SpringJDBC.service;

import org.gayatri.SpringJDBC.DAO.StudentRepo;
import org.gayatri.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studRepo;

    public StudentRepo getStudRepo() {
        return studRepo;
    }
    @Autowired
    public void setStudRepo(StudentRepo studRepo) {
        this.studRepo = studRepo;
    }

    public void addStudent(Student student){
        studRepo.save(student);
    }

    public List<Student> getStudents() {
        return studRepo.findAll();
    }
}
