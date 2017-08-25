package com.khasanov.BuilderPattern;

public class Address {

    private final String city;

    private final String district;

    private final String streetHome;

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreetHome() {
        return streetHome;
    }

    //Address klassni builderi
    public static class Builder{

        private final String city;
        private final String district;

        private String streetHome = "";

        public Builder(String city, String district) {
            this.city = city;
            this.district = district;
        }

        public Builder setStreetHome(String streetHome) {
            this.streetHome = streetHome;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }


    //final maydonlarni shu yerda yuklaymiz
    private Address(Builder builder){
        city = builder.city;
        district = builder.district;
        streetHome = builder.streetHome;

    }
}
