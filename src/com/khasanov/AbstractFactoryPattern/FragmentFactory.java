package com.khasanov.AbstractFactoryPattern;

public class FragmentFactory extends AbstractFactory{


    @Override
    MainActivity getActivity(String activityName) {
        return null;
    }

    public MainFragment getFragment(String fragmentName){

        if (fragmentName == null) return null;

        if (fragmentName.equalsIgnoreCase("profilefragment")){
            return new ProfileFragment();
        }else if (fragmentName.equalsIgnoreCase("settingsfragment")){
            return new SettingsFragment();
        }

        return null;
    }
}
