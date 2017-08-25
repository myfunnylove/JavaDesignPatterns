package com.khasanov.BuilderPattern;

public class User {

    private final String firstName;

    private final String lastName;

    private final int age;

    private final Address address;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }


    //User klassni builderi
    public static class Builder{

        private final String firstName;

        private final String lastName;

        private final int age;

        private Address address;

        public Builder(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Builder setAddress(Address address) {
            this.address = address;

            return this;
        }

        public User build(){
            return new User(this);
        }


    }

    //final maydonlar hammas konstruktor argumentiga joylashtirmasdan turib yuklanadi
    private User(Builder builder){

        firstName = builder.firstName;
        lastName = builder.lastName;
        age =builder.age;
        address = builder.address;
    }
}
