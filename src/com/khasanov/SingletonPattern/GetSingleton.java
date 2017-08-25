package com.khasanov.SingletonPattern;

public class GetSingleton {

    public static void main(String[] args) {

        SingletonFragment singletonFragment = SingletonFragment.getInstance();

        singletonFragment.showMessage();

    }
}
