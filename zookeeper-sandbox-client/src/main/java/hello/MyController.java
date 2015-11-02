package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MyController {
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping(value="/results")
    @HystrixCommand(fallbackMethod="getDefaultValue")
    public String doOtherStuff() {
        String results = restTemplate.getForObject("http://application/", String.class);
        return results;
    }
    
    public String getDefaultValue() {
    	return "THIS IS DEFAULT VALUE!";
    }
}