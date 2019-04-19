package com.stx.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**  

* <p>Title: EurekaServerApplication</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月19日  

*/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
