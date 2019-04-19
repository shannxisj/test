package com.stx.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  

* <p>Title: EurekaClient</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月19日  

*/
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication  {
	 public static void main(String[] args) {
	        SpringApplication.run(EurekaClientApplication.class, args);
	    }

	    @Value("${server.port}")
	    String port;
	    @RequestMapping("/")
	    public String home() {
	        return "hello world from port " + port;
	     }
}
