package com.stx.config;

/**  

* <p>Title: ConfigClientApplication</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月19日  

*/
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${hello}")
    String hello;
    @RequestMapping("/hello")
    public String hello(){
        return hello;
    }
}