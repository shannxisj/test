package com.stx.Ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  

* <p>Title: HelloControll</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月20日  

*/
@RestController
public class HelloControll {
	
	@Autowired
	HelloService service;
	@RequestMapping("/")
    public String LoadBalancedService() {
    	return service.getHelloContent();
    }
}
