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

		// Qualifier, Collection, Map injection
		var qualifierAutowiredDI = ctx.getBean("qualifierAutowiredDI", QualifierAutowiredDI.class);
		System.out.println(qualifierAutowiredDI);

		// Injecting a value from application.properties
		var injectingValues = ctx.getBean("injectingValues", InjectingValues.class);
		System.out.println(injectingValues);

		// Process arguments
		var processArguments = ctx.getBean("processArguments", ProcessArguments.class);
		System.out.println(processArguments);


		// Beans created in Configuration class 
		MyBean bean2 = ctx.getBean("myBean", MyBean.class);
		System.out.println(bean2);

		// Beans created in Configuration class
		Person person = ctx.getBean("person", Person.class);	
		System.out.println(person);

		// Beans created in Configuration class
		Person jane = ctx.getBean("jane", Person.class);
		System.out.println(jane);

		// Autowire a bean created in Configuration class
		AutowiredBean autowiredBean = ctx.getBean( AutowiredBean.class);
		System.out.println(autowiredBean);

		
		
		


		



	}

}
