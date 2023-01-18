package net.rumq.sb.demostd;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Prototype scope means that a new bean instance is created every time a
 * dependency is injected.
 */
@Component
@Scope("prototype")
public class PrototypeScopeComponent {
    
        public PrototypeScopeComponent() {
            System.out.println("PrototypeScopeComponent created");
        }
    
        @Override
        public String toString() {
            
            return "Hello from PrototypeScopeComponent";
        }
}
