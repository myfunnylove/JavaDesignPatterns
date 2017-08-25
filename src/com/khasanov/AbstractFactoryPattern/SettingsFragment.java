package com.khasanov.AbstractFactoryPattern;

public class SettingsFragment implements MainFragment {
    @Override
    public void onCreateView() {
        System.out.println("SettingsFragment oncreateview method called");
    }
}
