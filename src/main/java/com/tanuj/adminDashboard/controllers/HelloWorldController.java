package com.tanuj.adminDashboard.controllers;

import com.tanuj.adminDashboard.DTO.Configuration;
import com.tanuj.adminDashboard.DTO.HelloWorldBean;
import com.tanuj.adminDashboard.DTO.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//controller
@RestController
public class HelloWorldController {

    //GET
    //URI /heelloworld
    //method helloworld
    @Autowired
    Configuration configuration;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public LimitsConfiguration helloWorld(){
        return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalised")
    public String helloWorldInternational(@RequestHeader(name="Accept-language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message", null,locale);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable  String name){
        return new HelloWorldBean(String.format("hello world,%s",name));
    }

}
