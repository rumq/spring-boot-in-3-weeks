package net.rumq.sb.demostd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
 * The @Configuration annotation tells Spring that this class is a configuration class
 * The @Bean annotation tells Spring that the method will return a bean that will be managed by the Spring container
 * The bean name is the method name by default, but you can override it by passing a name to the @Bean annotation
 */
 @Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        MyBean b = new MyBean();
        b.setField1("foo");
        b.setField2("bar");
        return b;
    }

    @Bean
    public Person person() {
        return new Person("John", 42);
    }

    @Bean(name = "jane")
    @Primary
    public Person person2() {
        return new Person("Jane", 32);
    }

}
