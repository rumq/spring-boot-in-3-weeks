package net.rumq.sb.demostd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Second Demo Application
 * 
 * Look at this after you've seen the First Demo Application
 * here pawarv/demo
 * 
 * Run this as below or from your IDE
 * 1. Go to root directory `cd
 * /home/vikram/git/spring-boot-in-3-weeks/pawarv/demostd`
 * 2. Run `mvn spring-boot:run`
 * 
 * 
 * 
 */
@SpringBootApplication
public class DemostdApplication {

	public static void main(String[] args) {

		// Start the Spring Boot application
		ApplicationContext ctx = SpringApplication.run(DemostdApplication.class, args);

		// 01 Get the bean by type
		var bean = ctx.getBean(MyComponent.class);
		System.out.println("01 : Getting bean By Type getBean(MyComponent.class) : " + bean);

		// 02A Get the bean by name
		var fancyNameComponent = ctx.getBean("FancyNameComponent");
		System.out.println(fancyNameComponent);
		System.out.println("02A : Getting bean By Name getBean(FancyNameComponent.class) : " + fancyNameComponent);

		// 02B Get the bean by name and type
		var fancyNameComponent2 = ctx.getBean("FancyNameComponent", NamedComponent.class);
		System.out.println("02B : Getting bean By Name and Type getBean(FancyNameComponent.class, NamedComponent.class) : "
				+ fancyNameComponent2);

		// 03 Show that the bean is a singleton
		var singletonScopeComponent = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
		System.out.println("03A : " + singletonScopeComponent);
		var singletonScopeComponent2 = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
		System.out.println("03B : " + singletonScopeComponent2);
		System.out.println("03C : (singletonScopeComponent == singletonScopeComponent2)=" + (singletonScopeComponent == singletonScopeComponent2));

		// 04 Show that the bean is lazy (Check when it's created. See what happens if you
		// remove the @Lazy annotation)
		var lazyComponent = ctx.getBean("lazyComponent", LazyComponent.class);
		System.out.println("04 LazyComponent Access: " + lazyComponent);

		// 05 Show that the bean is a prototype
		var prototypeScopeComponent = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
		System.out.println("05A : " + prototypeScopeComponent);
		var prototypeScopeComponent2 = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
		System.out.println("05B : " + prototypeScopeComponent2);
		System.out.println("05C : (prototypeScopeComponent == prototypeScopeComponent2)=" + (prototypeScopeComponent == prototypeScopeComponent2));
		

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
		AutowiredBean autowiredBean = ctx.getBean(AutowiredBean.class);
		System.out.println(autowiredBean);

	}

}
