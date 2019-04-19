package com.stx.zuul;

/**  

* <p>Title: ServiceZuulApplication</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月20日  

*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
}
