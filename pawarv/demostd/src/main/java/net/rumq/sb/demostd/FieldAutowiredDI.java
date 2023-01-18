package net.rumq.sb.demostd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * Autowired means that the bean is injected automatically.
 * The bean is injected by type.
 * If there are multiple beans of the same type, the bean is injected by name.
 * If there are multiple beans of the same type and name, the bean is injected by qualifier.
 * If there are multiple beans of the same type and name and qualifier, the bean is injected by field name.
 * 
 */
@Component
public class FieldAutowiredDI {

    // field injection
    @Autowired
    private SingletonScopeComponent singletonScopeComponent;

    public FieldAutowiredDI() {
        System.out.println("AutowiredDependency created");
    }

    @Override
    public String toString() {

        return "Hello from AutowiredDependency - " + singletonScopeComponent.toString() + "";
    }
}
