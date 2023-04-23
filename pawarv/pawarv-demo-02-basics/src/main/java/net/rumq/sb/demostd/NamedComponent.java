package net.rumq.sb.demostd;

import org.springframework.stereotype.Component;

@Component("FancyNameComponent")
public class NamedComponent {
    
        public NamedComponent() {
            System.out.println("NamedComponent created");
        }
    
        @Override
        public String toString() {
            
            return "Hello from NamedComponent";
        }
}
