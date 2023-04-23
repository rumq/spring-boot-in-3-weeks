package net.rumq.sb.demostd;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Qualifier is used to inject a specific bean when there are multiple beans of the same type.
 * Triangle and Square are beans of the same type.
 * 
 * The bean is injected by qualifier.
 * 
 * Also demonstrates the use of Collection to inject all beans of the same type.
 *  
 * Also demonstrates the use of Map to inject all beans of the same type.
 * 
 * 
 * 
 */
@Component
public class QualifierAutowiredDI {

    @Autowired
    @Qualifier("square") // Interchange the qualifier to see the difference
    private Shape shape1;

    @Autowired
    @Qualifier("triangle") // Interchange the qualifier to see the difference
    private Shape shape2;

    @Autowired
    @Qualifier("square1") 
    private Shape shape3;
    

    @Autowired
    private Collection<Shape> shapes;

    @Autowired
    private Map<String, Shape> shapesMap;

    public QualifierAutowiredDI() {
        System.out.println("QualifierAutowiredDI created");
    }

    @Override
    public String toString() {

        return "Result of Dependency Injection " + 
                "\n  Autowired shape1:  " + shape1.toString() + 
                " \n   Type of shape1 : " + shape1.getClass()  +
                "\n  Autowired shape2: " + shape2.toString() +
                " \n   Type of shape2 : " + shape2.getClass() +
                " \n Autowired Collection<Shape> shapes     : " + shapes.toString() +
                " \n Autowired Map<String, Shape> shapesMap : " + shapesMap.toString() +                
                "";
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

@Component
class Square1 implements Shape {

    public Square1() {
        System.out.println("Square1 created");
    }

    @Override
    public String toString() {

        return "Hello from Square1";
    }

    @Override
    public String getShape() {

        return "Square1";
    }

}
