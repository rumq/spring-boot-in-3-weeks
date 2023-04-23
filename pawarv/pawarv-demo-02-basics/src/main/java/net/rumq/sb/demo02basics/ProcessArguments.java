package net.rumq.sb.demo02basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;


/*
 *  This class is used to demonstrate how to access command line arguments
 *  passed to the application.
 * 
 *  You can see the options and non-option arguments in the console output.
 * 
 *  Run it with the following command:
 *  mvn spring-boot:run -Dspring-boot.run.arguments="--target=foo --target=bar baz"
 * 
 */
@Component
public class ProcessArguments {
    
    @Autowired
    public  ProcessArguments(ApplicationArguments args) {
        System.out.println("Raw (unprocessed) args");
        for (String sourceArg : args.getSourceArgs()) {
            System.out.println("  " + sourceArg);
        }

        System.out.println("Option names");
        for (String optName : args.getOptionNames()) {
            System.out.println("  " + optName);
        }

        System.out.println("Values for 'target' option");
        if (args.containsOption("target")) {
            for (String optValue : args.getOptionValues("target")) {
                System.out.println("  " + optValue);
            }
        }

        System.out.println("Non-option args");
        for (String nonOptArg : args.getNonOptionArgs()) {
            System.out.println("  " + nonOptArg);
        }


    }
}
