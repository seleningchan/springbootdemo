package com.example.springboot;

import com.example.springboot.dao.UserRepositoryImpl;
import com.example.springboot.dao.BlogRepository;
import com.example.springboot.entity.Blog;
import com.example.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserRepositoryImpl userDao;
    @Autowired
    private BlogRepository blogRepository;

    @Test
    public void testBlog(){
        Blog blog = new Blog("jdbc教程","1111");
        //blog.setTitle("jdbc教程");
        //blog.setContent("jdbc内容");
        System.out.println("保存聚合blog");
        Blog dbBlog = blogRepository.save(blog);
        //System.out.println("blog:" + blogRepository.findById(dbBlog.getId()).toString());

    }

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        User user= userDao.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(2l);
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(1l);
    }

}
