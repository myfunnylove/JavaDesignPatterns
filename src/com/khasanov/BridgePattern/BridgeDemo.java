package com.khasanov.BridgePattern;

public class BridgeDemo {

    public static void main(String[] args) {

        BaseRemote baseRemote = new BaseRemote(new TV());
        baseRemote.turnOn();
        baseRemote.volumeUp();


        MultiRemote multiRemote = new MultiRemote(new TV());
        multiRemote.turnOn();

    }
}
