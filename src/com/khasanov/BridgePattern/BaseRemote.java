package com.khasanov.BridgePattern;

public class BaseRemote implements Remote {

    protected Device device;

    public BaseRemote(Device device) {
        this.device = device;
    }

    public BaseRemote() {
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume() - 1);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume() + 1);

    }

    @Override
    public void turnOn() {
        device.setEnable(true);

    }

    @Override
    public void turnOff() {
        device.setEnable(false);

    }
}
