package net.rumq.sb.demostd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorAutowiredDI {

    private SingletonScopeComponent singletonScopeComponent;
    private Triangle prototypeScopeComponent;
    private LazyComponent lazyComponent;
    private NamedComponent namedComponent;

    // constructor injection    
    // the @Autowired annotation is not required if there is only one constructor
    @Autowired
    public ConstructorAutowiredDI(SingletonScopeComponent singletonScopeComponent,
            Triangle prototypeScopeComponent, LazyComponent lazyComponent,
            NamedComponent namedComponent) {
        this.singletonScopeComponent = singletonScopeComponent;
        this.prototypeScopeComponent = prototypeScopeComponent;
        this.lazyComponent = lazyComponent;
        this.namedComponent = namedComponent;
    }

    public ConstructorAutowiredDI() {
        System.out.println("ConstructorAutowiredDI created");
    }

    @Override
    public String toString() {

        return "ConstructorAutowiredDI [singletonScopeComponent=" + singletonScopeComponent
                + ", prototypeScopeComponent=" + prototypeScopeComponent + ", lazyComponent="
                + lazyComponent + ", namedComponent=" + namedComponent + "]";
    }

}
