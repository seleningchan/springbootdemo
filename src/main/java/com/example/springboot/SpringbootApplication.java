package com.example.springboot;

import com.example.springboot.dao.BlogRepository;
import com.example.springboot.dao.StudentRepository;
import com.example.springboot.entity.Blog;
import com.example.springboot.entity.JPAStudent;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.Optional;

@ImportResource(locations = {"classpath:/beans.xml"})
@MapperScan(basePackages = "com.example.springboot.studentmapper")
@EnableJdbcRepositories
@SpringBootApplication
public class SpringbootApplication {
    private Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    /*
    *这里引用JPA，spring-data-jdbc会有冲突，它们都实现相同接口，springboot无法创建实现，
    * 无法找到bean
     */
    @Bean
    public CommandLineRunner testBlog(BlogRepository blogRepository) {
        return args -> {
            Blog blog = new Blog("jdbc教程","1111");
            System.out.println("保存聚合blog");
            Blog dbBlog = blogRepository.save(blog);
            logger.info("保存聚合blog");
            logger.info("blog:" + blogRepository.findById(dbBlog.getId()).toString());
        };
    }

    @Bean
    public CommandLineRunner studentTest(StudentRepository studentRepository){
        return args -> {
            logger.info("新增一个学生");
            studentRepository.save(new JPAStudent("小红",0,20,"大学生"));
            logger.info("查询所有学生");
            studentRepository.findAll().forEach(s -> {
                logger.info(s.toString());
            });
            logger.info("查询id为1的学生");
            Optional<JPAStudent> student = studentRepository.findById(1);
            logger.info(student.get().toString());

            logger.info("查询grade为大学生的所有学生");
            studentRepository.findByGrade("大学生").forEach(s -> {
                logger.info(s.toString());
            });
        };
    }
}
