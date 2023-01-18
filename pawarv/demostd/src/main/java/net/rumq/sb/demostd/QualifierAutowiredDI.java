package net.rumq.sb.demostd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 *  Qualifier is used to inject a specific bean when there are multiple beans of the same type.
 *  Triangle and Square are beans of the same type.
 *  The bean is injected by qualifier.
 * 
 */
@Component
public class QualifierAutowiredDI {

    @Autowired
    @Qualifier("square")  // Interchange the qualifier to see the difference
    private Shape shape1;

    @Autowired
    @Qualifier("triangle") // Interchange the qualifier to see the difference
    private Shape shape2;

    public QualifierAutowiredDI() {
        System.out.println("QualifierAutowiredDI created");
    }

    @Override
    public String toString() {

        return "Hello from QualifierAutowiredDI - " + shape1.toString() + " - " + shape2.toString() + "";
    }

}

interface Shape {

    public String getShape();

}

@Component
class Triangle implements Shape {

    public Triangle() {
        System.out.println("Triangle created");
    }

    @Override
    public String toString() {

        return "Hello from Triangle";
    }

    @Override
    public String getShape() {

        return "Triangle";
    }

}

@Component
class Square implements Shape {

    public Square() {
        System.out.println("Square created");
    }

    @Override
    public String toString() {

        return "Hello from Square";
    }

    @Override
    public String getShape() {

        return "Square";
    }

}
