package com.khasanov.DecoratorPattern;

public interface DataSource {

    void writeData(String data);
    String readData();

}
