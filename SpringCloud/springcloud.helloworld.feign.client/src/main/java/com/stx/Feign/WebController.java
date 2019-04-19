package com.stx.Feign;

/**  

* <p>Title: WebController</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月20日  

*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Autowired HelloWorldService helloWorldFeignService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return helloWorldFeignService.sayHello();
    }
}
