package hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

	@Autowired
	private PortListener listener;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		return "Hello World! Header1 value: " + request.getHeader("header1") + "["+listener.getPort()+"]";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}