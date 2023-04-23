package net.rumq.sb.demostd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class LazyComponent {

    public LazyComponent() {
        System.out.println("04 LazyComponent Creation: LazyComponent created");
    }

    @Override
    public String toString() {

        return "Hello from LazyComponent";
    }

}
