# Java Design Patterns

### Linklar 
1. [Factory Pattern](README.md/Factory#Pattern)
2. [Abstract Factory Pattern](README.md/Abstract#Factory#Pattern)

### Factory Pattern 


> Universal shape interface
  
  ```java
public interface Shape {
    void draw();
}
  ```
> Uchta shape categoriyasiga tegishli class yaratamiz  

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw() method");

    }
}
```

```java

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw() method");
    }
}
```

```java 
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw() method");

    }
}
```

> Endi asosiy **Factory Pattern** ga ega class yaratamiz

```java
public class ShapeFactory {

    public Shape getShape(String shapeType){

        if (shapeType == null){
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
         return null;
    }

}
```
> endi priznak bilan kerakli class ni olamiz

```java
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle    = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape square    = shapeFactory.getShape("SQUARE");
        square.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
```
> console: 
```
Circle::draw() method
Square::draw() method
Rectangle::draw() method

Process finished with exit code 0
```        
  
### Abstract Factory Pattern 
