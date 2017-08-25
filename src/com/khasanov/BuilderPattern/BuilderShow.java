package com.khasanov.BuilderPattern;

public class BuilderShow {

    public static void main(String[] args) {

        User user1 = new User.Builder("Muhammadjon","Xasanov",23)
                .setAddress(new Address.Builder("Tashkent","M.Ulug'bek")
                .setStreetHome("Data 4 home")
                .build())
                .build();

        System.out.println(user1.getFirstName());

        System.out.println(user1.getAddress()
                                .getCity());
    }
}
