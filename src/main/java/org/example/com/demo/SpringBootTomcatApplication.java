package org.example.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @author :Amr Abdeldayem
 */


@SpringBootApplication
public class SpringBootTomcatApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTomcatApplication.class, args);
	}

}

