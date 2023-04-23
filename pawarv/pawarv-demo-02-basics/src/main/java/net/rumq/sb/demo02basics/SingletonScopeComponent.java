package net.rumq.sb.demo02basics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Singleton scope is the default scope for Spring beans.
 * 
 * The bean is created only once and the same instance is used for all the
 * dependencies.
 */
@Component
@Scope("singleton")
public class SingletonScopeComponent {
    
        public SingletonScopeComponent() {
            System.out.println("SingletonScopeComponent created " + this.hashCode());
        }
    
        @Override
        public String toString() {
            
            return "Hello from SingletonScopeComponent " + this.hashCode();
        }
}
