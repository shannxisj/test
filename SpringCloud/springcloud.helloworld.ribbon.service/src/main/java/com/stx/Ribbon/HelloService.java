package com.stx.Ribbon;

/**  

* <p>Title: HelloService</p>  

* <p>Description: </p>  

* @author stx  

* @date 2019年3月20日  

*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
    @Autowired 
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/",String.class);
    }

    public String serviceFailure() {
        return "hello world service is not available !";
    }
}
/*
 @HystrixCommand注解定义的fallbackMethod方法，需要特别注意的有两点：

第一，  fallbackMethod的返回值和参数类型需要和被@HystrixCommand注解的方法完全一致。否则会在运行时抛出异常。比如本例中，serviceFailure（）的返回值和getHelloContant()方法的返回值都是String。

第二，  当底层服务失败后，fallbackMethod替换的不是整个被@HystrixCommand注解的方法（本例中的getHelloContant), 替换的只是通过restTemplate去访问的具体服务。可以从中的system输出看到， 即使失败，控制台输出里面依然会有“call SERVICE-HELLOWORLD”。*/
/*
 * 这里关键代码就是, restTemplate.getForObject方法会通过ribbon负载均衡机制， 自动选择一个Hello word服务，

这里的URL是“http://SERVICE-HELLOWORLD/"，
其中的SERVICE-HELLOWORLD是Hello world服务的名字，
而注册到服务中心的有两个SERVICE-HELLOWORLD。 
所以，这个调用本质是ribbon-service作为客户端根据负载均衡算法自主选择了一个作为服务端的SERVICE-HELLOWORLD服务
。然后再访问选中的SERVICE-HELLOWORLD来执行真正的Hello world调用。
 * 
 * */
