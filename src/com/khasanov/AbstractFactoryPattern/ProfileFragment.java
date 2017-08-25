package com.khasanov.AbstractFactoryPattern;

public class ProfileFragment implements MainFragment {
    @Override
    public void onCreateView() {
        System.out.println("ProfileFragment oncreateview method called");
    }
}
