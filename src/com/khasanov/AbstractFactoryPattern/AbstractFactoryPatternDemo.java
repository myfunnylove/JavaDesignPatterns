package com.khasanov.AbstractFactoryPattern;

public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {


        /*
        *
        * Activity lar olinsin
        *
        * */
        AbstractFactory factory = FactoryProducer.getFactory("activity");

        MainActivity profileActivity = factory.getActivity("profileactivity");

        profileActivity.onCreate();

        MainActivity settingsActivity = factory.getActivity("settingsactivity");

        settingsActivity.onCreate();

        /*
        *
        * Fragment lar olinsin
        *
        * */
        factory = FactoryProducer.getFactory("fragment");


        MainFragment profileFragment = factory.getFragment("profilefragment");

        profileFragment.onCreateView();





        MainFragment settingsFragment = factory.getFragment("settingsfragment");

        settingsFragment.onCreateView();


    }
}
