package com.ishmamruhan.JpaAndEntityManagerPractice.Config;

import com.ishmamruhan.JpaAndEntityManagerPractice.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Init {

    @Autowired
    private UserServiceImpl userService;

    @PostConstruct
    public void init(){
        userService.playWithEntityManager();
    }

}
