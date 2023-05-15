package demo.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
 * cd demos/demo-07-spring-boot-techniques
 * mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=production"
 * mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=development"
 */
// @SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "app4");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        MyBean4 bean4 = ctx.getBean(MyBean4.class);
        System.out.println(bean4);

        MyBeanWithValues beanWithValues = ctx.getBean(MyBeanWithValues.class);
        System.out.println(beanWithValues);
    }
}
