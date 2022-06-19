package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate(){
//		return new RestTemplate();
//	}


//	@Autowired
//	public void getEnv(Environment e)
//	{
//		System.out.println("utsav: "+e.getProperty("user.msg"));
//	}

}
