package com.example.springboot.dao;

import com.example.springboot.entity.Student;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void select(){
        this.jdbcTemplate.queryForList("select * from tb_student");
    }
    public Integer count(){
        return this.jdbcTemplate.queryForObject("select count(*) from tb_student", Integer.class);
    }
    public Integer countByName(String name){
        return this.jdbcTemplate.queryForObject("select count(*) from tb_student where name =?", Integer.class, name);
    }

    public Student selectById(Integer id){
        return this.jdbcTemplate.queryForObject("select * from tb_student where id=?", studentRowMapper, id);
    }

    public void insert(Student student){
        this.jdbcTemplate.update("insert into tb_student(name,sex,age,grade) value (?,?,?,?)",
                student.getName(),student.getSex(), student.getAge(),student.getGrade());
    }
    public void Update(Student student){
        this.jdbcTemplate.update("update tb_student set grade = ?, sex = ? where id = ?",
                student.getGrade(),student.getSex(), student.getId());

        //this.jdbcTemplate.update(
        //        "delete from tb_student  where id = ?",
        //       2);

        //this.jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
    }

    public void batchUpdate(List<Student> students){
        this.jdbcTemplate.batchUpdate("insert into tb_student(name,sex,age,grade) value (?,?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, students.get(i).getName());
                ps.setInt(2, students.get(i).getSex());
                ps.setInt(3, students.get(i).getAge());
                ps.setString(4, students.get(i).getGrade());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
    }

    private final RowMapper<Student> studentRowMapper = (resultSet, rowNum) -> {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setSex(resultSet.getInt("sex"));
        student.setAge(resultSet.getInt("age"));
        student.setGrade(resultSet.getString("grade"));
        return student;
    };
}
