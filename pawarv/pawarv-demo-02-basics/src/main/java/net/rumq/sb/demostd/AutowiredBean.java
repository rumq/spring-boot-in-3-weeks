package net.rumq.sb.demostd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowiredBean {

    @Autowired
    private Person honda;

    @Override
    public String toString() {        
        return "AutowiredBean: " + honda ;
    }
    
}
