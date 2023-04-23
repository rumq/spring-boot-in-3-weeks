package net.rumq.sb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Demo - First application
 *  @author Pawar
 * 
 *  Look at this after you have gone through demo-02 & demo-03
 *  	
 *  1. This runs on port 8111, so you can access it at http://localhost:8111
 *  2. The port is set here pawarv/demo/src/main/resources/application.properties
 *  3. The text `Hello World` is set here pawarv/demo/src/main/resources/templates/index.html
 *  4. Run this by `mvn spring-boot:run` from the root directory or the run option in your IDE.
 *
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
