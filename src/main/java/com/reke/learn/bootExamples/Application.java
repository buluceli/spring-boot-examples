package com.reke.learn.bootExamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * Created by sinocall on 2017/7/6.
 */

@SpringBootApplication
@ImportResource
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);

		app.run(args);


	}
}
