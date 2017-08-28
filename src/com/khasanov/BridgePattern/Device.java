package com.khasanov.BridgePattern;

public interface Device {

    void setVolume(int i);
    int getVolume();

    void setEnable(boolean enable);
    boolean isEnabled();


    void status();

}
