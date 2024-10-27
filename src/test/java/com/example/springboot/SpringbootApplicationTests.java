package com.example.springboot;

import com.example.springboot.dao.StudentDao;
import com.example.springboot.entity.MybatisStudent;
import com.example.springboot.entity.Person;
import com.example.springboot.entity.Student;
import com.example.springboot.studentmapper.StudentMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Autowired
    StudentDao studentDao;
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        List<MybatisStudent> userList = studentMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testStudentdao() throws JsonProcessingException {
        Integer count = studentDao.countByName("张三");
        System.out.println("sql count is "+count);
        Student student = studentDao.selectById(1);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(student));
        student = new Student();
        student.setName("王五");
        student.setSex(1);
        student.setAge(11);
        student.setGrade("highschool");
        studentDao.insert(student);
    }

    @Test
    public void testConfigurationService(){
        boolean configed = ioc.containsBean("personServiceByConfiguration");
        if(configed)
            System.out.println("Has personServiceByConfiguration");
        else
            System.out.println("Hasn't personServiceByConfiguration");
    }
    @Test
    public void testHelloService(){
        boolean b = ioc.containsBean("personService");
        if(b){
            System.out.println("personService已经添加到IOC容器中");
        }else{
            System.out.println("personService没有添加到IOC容器中");
        }
    }

}
