package com.alta.japprtc2.controller;

import com.alta.japprtc2.config.JConfig;
import com.alta.japprtc2.dao.impl.UserDao;
import com.alta.japprtc2.pojo.ReportInfo;
import com.alta.japprtc2.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alta.japprtc2.pojo.User;

import java.util.List;
/**
 * Created by baiba on 2018-09-08.
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private JConfig jconfig;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/hello")
    public String index(){
        return "hello world.";
    }

    //测试配置文件
    @RequestMapping("/helloex")
    public String indexex(){
        return  jconfig.Version;
    }

    //测试数据库操作
    @RequestMapping("/getuser")
    public List<User> getUser(){
        List<User> users = userDao.all();
        return users;
    }

    //测试redis
    @RequestMapping("/redis")
    public List<ReportInfo> redis(){
        ReportInfo reportInfo =ReportInfo.builder().accesskey("accesskey_001").module("ice").build();
        redisUtils.saveCache("key_001",reportInfo);
        List<ReportInfo> all = redisUtils.getCache("key_001",ReportInfo.class);
        return all;
    }
}
