package demo.differentpropertiesfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * cd demos/demo-07-spring-boot-techniques
 * 1) mvn spring-boot:run  (default application.properties)
 * 2) mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.name=app2"
 * 3) export SPRING_CONFIG_NAME=app2; mvn spring-boot:run
 * 4) Uncommet System.setProperty("spring.config.name", "app2"); in main() method
 */
// @SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // System.setProperty("spring.config.name", "app2");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        MyBean2 bean2 = ctx.getBean(MyBean2.class);
        System.out.println(bean2);
    }
}
