package org.gayatri.SpringJDBC.DAO;

import org.gayatri.SpringJDBC.modul.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Student s){
        String sql = "insert into Student(rollNo, name, marks) values(?,?,?)";
        int rows = jdbcTemplate.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "select * from Student";

        RowMapper<Student> mapper = (rs, rowNum) ->{
                Student student = new Student();
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));

                return student;
        };

        return jdbcTemplate.query(sql, mapper);
    }
}
