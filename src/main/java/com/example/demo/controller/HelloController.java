package com.example.demo.controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Mapper.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.MyException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Resource
    UserRepository userRepository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/hello")
    public String hello() throws Exception {
        System.out.println("11111");
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        System.out.println("/json");
        throw new MyException("发生错误");
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("11111");
        jdbcTemplate.update("insert into user(NAME, AGE) values(?, ?)", "lin", 12);
        return "SUCCESS";
    }

    @RequestMapping("/findByName")
    public void findByName() {
        System.out.println(2222222);
        userRepository.save(new User("lin", 000));
    }

    @RequestMapping("/saveRedis")
    public void saveRedis() {
        System.out.println("saveRedis");
        stringRedisTemplate.opsForSet().add("saveRedis","22222");
        return;
    }

    @RequestMapping("/mybatisTest")
    @Transactional
    public void mybatisTest() {
        System.out.println(0000);
        userMapper.insert(new User("lin",3));
        userMapper.insert(new User("lin111111111111111111",99999999));
    }

    @RequestMapping("/userList")
    public List<Map<String,Object>> userList() {
        System.out.println("userList");
        System.out.println(userMapper.userList());
//        return "SUCCESS";
        return userMapper.userList();
    }

    @RequestMapping("/userFindByName")
    public List<User> userFindByName() {
        System.out.println(userRepository.findByName("lin"));
        return userRepository.findByName("lin");
    }

    @RequestMapping("/rabbitTest")
    public void rabbitTest() {
        String data = "hello" + new Date();
        System.out.println("生产一条消息 " + data);
        this.rabbitTemplate.convertAndSend("hello",data);
    }

}
