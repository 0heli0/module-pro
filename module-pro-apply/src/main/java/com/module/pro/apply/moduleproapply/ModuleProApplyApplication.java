package com.module.pro.apply.moduleproapply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ModuleProApplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleProApplyApplication.class, args);
    }

    @ResponseBody
    @RequestMapping(value = "hello")
    public String hello(){
        return "hello";
    }
}
