package com.example.springboot.dao;

import com.example.springboot.entity.Blog;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.repository.CrudRepository;



//@Repository
@EnableJdbcRepositories
public interface BlogRepository extends CrudRepository<Blog, Integer> {
    //List<Blog> findAll();
}
