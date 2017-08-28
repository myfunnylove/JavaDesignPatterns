package com.khasanov.BridgePattern;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Radio implements Device {

    private boolean isEnabled = false;
    private int volume = 0;


    @Override
    public void setVolume(int i) {
        volume = i;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setEnable(boolean enable) {
        isEnabled = enable;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void status() {
        System.out.println("=====================");
        System.out.println("| volume: "+volume);
        System.out.println("| isEnabled: "+isEnabled);
        System.out.println("=====================");
    }
}
