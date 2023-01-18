package net.rumq.sb.demostd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemostdApplication {

	public static void main(String[] args) {

		// Start the Spring Boot application
		ApplicationContext ctx = SpringApplication.run(DemostdApplication.class, args);

		// Get the bean by type
		var bean = ctx.getBean(MyComponent.class);
		System.out.println(bean);

		// Get the bean by name
		var fancyNameComponent = ctx.getBean("FancyNameComponent");
		System.out.println(fancyNameComponent);

		// Show that the bean is a singleton
		var singletonScopeComponent = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
		System.out.println(singletonScopeComponent);



	}

}
