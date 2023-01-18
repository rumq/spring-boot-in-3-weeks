package net.rumq.sb.demostd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InjectingValues {

    @Value("${company.name}") // Injecting a value from application.properties
    private String value;

    @Value("${another.company.name:Google}") // Injecting a value from application.properties with a default value
    private String valueWithDefault;

    @Value("#{systemProperties['user.name']}") // Injecting a value from system properties
    private String systemProperty;

    @Value("#{T(java.lang.Math).random() * 100.0}") // Injecting a value from an expression
    private double randomNumber;

    @Value("#{ 8 * 5 }") // Injecting a value from an expression
    private String hoursWorked;

    @Override
    public String toString() {
        return "InjectingValues \n" + 
                "[valueWithDefault=" + valueWithDefault + "] \n" +
                "[systemProperty=" + systemProperty + "] \n" +
                "[randomNumber=" + randomNumber + "] \n" +
                "[hoursWorked=" + hoursWorked + "] \n" +
                "[value=" + value + "]";
    }

}
