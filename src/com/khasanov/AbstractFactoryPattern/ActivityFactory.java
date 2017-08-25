package com.khasanov.AbstractFactoryPattern;

public class ActivityFactory extends AbstractFactory {


    public MainActivity getActivity(String activityName){

        if (activityName == null) return null;

        if (activityName.equalsIgnoreCase("profileactivity")){
            return new ProfileActivity();
        }else if (activityName.equalsIgnoreCase("settingsactivity")){
            return new SettingsActivity();
        }

        return null;
    }

    @Override
    MainFragment getFragment(String fragmentName) {
        return null;
    }
}
