package com.khasanov.FactoryPattern;

public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle    = shapeFactory.getShape("CIRCLE");
        circle.draw();

        Shape square    = shapeFactory.getShape("SQUARE");
        square.draw();

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

    }
}
