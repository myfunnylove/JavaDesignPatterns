package com.khasanov.DecoratorPattern;

public class DecoratorDemo {

    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        BaseDecorator baseDecorator = new CompressionDecorator(new EncryptionDecorator(new BaseDecorator(new FileDataSource(salaryRecords)))); // decorator

        baseDecorator.writeData(salaryRecords);

        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(baseDecorator.readData());
    }
}
