package net.rumq.sb.demostd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyComponent {

    public LazyComponent() {
        System.out.println("LazyComponent created");
    }

    @Override
    public String toString() {

        return "Hello from LazyComponent";
    }

}
