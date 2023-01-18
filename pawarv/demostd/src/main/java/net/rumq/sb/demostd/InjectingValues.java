package net.rumq.sb.demostd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InjectingValues {

    @Value("${company.name}") // Injecting a value from application.properties
    private String value;

    @Value("${another.company.name:Google}") // Injecting a value from application.properties with a default value
    private String valueWithDefault;

    // Using SpEL (Spring Expression Language)
    @Value("#{systemProperties['user.name']}") // Injecting a value from system properties
    private String systemProperty;

    @Value("#{T(java.lang.Math).random() * 100.0}") // Calling a Static method
    private double randomNumber;

    @Value("#{ 8 * 5 }") // Injecting a value from an expression
    private String hoursWorked;

    @Value("#{ new java.util.Date()}") // Injecting a value from an expression
    private String date;

    @Value("#{info.cities[3]}") // accessing a list using SpEL
    private String city;

    @Value("#{info.currencies['GBP']}") // accessing a map using SpEL
    private String currency;

    @Override
    public String toString() {
        return "InjectingValues \n" +
                "[valueWithDefault=" + valueWithDefault + "] \n" +
                "[systemProperty=" + systemProperty + "] \n" +
                "[randomNumber=" + randomNumber + "] \n" +
                "[hoursWorked=" + hoursWorked + "] \n" +
                "[date=" + date + "] \n" +
                "[city=" + city + "] \n" +
                "[currency=" + currency + "] \n" +
                "[value=" + value + "]";
    }

}

@Component
class Info {

    public List<String> cities = List.of("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
            "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
            "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
            "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
            "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
            "West Virginia", "Wisconsin", "Wyoming");

    public Map<String, String> currencies = Map.of("USD", "US Dollar", "EUR", "Euro", "GBP", "British Pound", "INR",
            "Indian Rupee");

}
