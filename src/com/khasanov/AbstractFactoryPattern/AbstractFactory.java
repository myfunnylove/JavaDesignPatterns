package com.khasanov.AbstractFactoryPattern;

public abstract class AbstractFactory {

    abstract MainActivity getActivity(String activityName);
    abstract MainFragment getFragment(String fragmentName);
}
