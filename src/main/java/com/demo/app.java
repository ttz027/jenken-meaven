package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.demo.pojo.test;

//@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan(basePackages="com.demo.*")//扫描controller包
//@MapperScan(basePackages="com.demo.dao") //扫描dao包，加上此注解 就不需要dao接口上加@Mapper
public class app  extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(app.class, args);
	}
	
	/*@Bean
	@Autowired
	public test gett(test tes){
		return tes;
	}*/
	
	@Bean
	public test getTest(){
		return new test();
	}
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(app.class);
	    } 
}
