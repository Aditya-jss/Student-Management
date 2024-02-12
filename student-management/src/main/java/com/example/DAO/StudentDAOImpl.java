package com.example.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.api.Student;

import com.example.RowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudent() {
        String sql = "SELECT * FROM `student-directory`.student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public void saveStudent(Student student) {
        Object[] sqlParameters = { student.getName(), student.getMobile(), student.getCountry() };
        String sql = "INSERT INTO students(name, mobile, country) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, sqlParameters);
        System.out.println("1 record inserted...");
    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT * FROM students WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE students SET name=?, mobile=?, country=? WHERE id=?";
        jdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
        System.out.println("1 record updated");
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE ID=?";
        jdbcTemplate.update(sql, id);
    }
}
