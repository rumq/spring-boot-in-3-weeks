package demo.commandlineproperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
   cd demos/demo-07-spring-boot-techniques
 * mvn spring-boot:run -Dspring-boot.run.arguments="--name=Amitabh"
 */
// @SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        MyBean1 bean1 = ctx.getBean(MyBean1.class);
        System.out.println(bean1);
    }
}
