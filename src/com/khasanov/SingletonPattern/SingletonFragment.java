package com.khasanov.SingletonPattern;

public class SingletonFragment {

    private static SingletonFragment mInstance;

    public static SingletonFragment getInstance(){
        if (mInstance == null) mInstance = new SingletonFragment();


        return mInstance;

    }

    private SingletonFragment(){

    }

    public void showMessage(){
        System.out.println("Singleton message");
    }
}
