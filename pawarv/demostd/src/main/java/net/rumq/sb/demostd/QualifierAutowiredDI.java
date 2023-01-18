package net.rumq.sb.demostd;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Qualifier is used to inject a specific bean when there are multiple beans of the same type.
 * Triangle and Square are beans of the same type.
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
    private Collection<Shape> shapes;

    @Autowired
    private Map<String, Shape> shapesMap;

    public QualifierAutowiredDI() {
        System.out.println("QualifierAutowiredDI created");
    }

    @Override
    public String toString() {

        return "Result of DI qualified as shape1 & shape2 - " + shape1.toString() + " - " + shape2.toString() +
                " \n Collection shapes autowired - " + shapes.toString() +
                " \n   Classes : shape1 :" + shape1.getClass() + " shape2 : " + shape2.getClass() +
                " \n Map shapes autowired - " + shapesMap.toString() +
                " \n   Classes : shape1 :" + shapesMap.get("square").getClass() + " shape2 : "
                + shapesMap.get("triangle").getClass() +
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
