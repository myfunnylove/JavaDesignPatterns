package com.khasanov.AbstractFactoryPattern;

public class FactoryProducer {

    public static AbstractFactory getFactory(String which){
        if (which.equalsIgnoreCase("activity")){
            return new ActivityFactory();
        }else if (which.equalsIgnoreCase("fragment")){
            return new FragmentFactory();
        }
        return null;
    }
}
