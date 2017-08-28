package com.khasanov.BridgePattern;

public class MultiRemote extends BaseRemote {

    MultiRemote(Device device){
        super.device = device;
    }

    public void mute(){
        device.setVolume(0);
    }
}
