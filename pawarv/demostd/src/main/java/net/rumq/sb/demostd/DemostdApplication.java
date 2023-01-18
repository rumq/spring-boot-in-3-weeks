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
		var singletonScopeComponent2 = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
		System.out.println(singletonScopeComponent2);
		assert singletonScopeComponent == singletonScopeComponent2;


		// Show that the bean is lazy (Check when it's created. See what happens if you remove the @Lazy annotation)
		var lazyComponent = ctx.getBean("lazyComponent", LazyComponent.class);
		System.out.println(lazyComponent);

		// Show that the bean is a prototype
		var prototypeScopeComponent = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
		System.out.println(prototypeScopeComponent);
		var prototypeScopeComponent2 = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
		System.out.println(prototypeScopeComponent2);
		assert prototypeScopeComponent != prototypeScopeComponent2;

		// Show that the bean is autowired
		var fieldAutowiredDI = ctx.getBean("fieldAutowiredDI", FieldAutowiredDI.class);
		System.out.println(fieldAutowiredDI);

		// Constructor injection
		var constructorAutowiredDI = ctx.getBean("constructorAutowiredDI", ConstructorAutowiredDI.class);
		System.out.println(constructorAutowiredDI);

		// Qualifier injection
		var qualifierAutowiredDI = ctx.getBean("qualifierAutowiredDI", QualifierAutowiredDI.class);
		System.out.println(qualifierAutowiredDI);
		



	}

}
