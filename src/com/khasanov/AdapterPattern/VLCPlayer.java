package com.khasanov.AdapterPattern;

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("play VLC name + "+fileName);
    }

    @Override
    public void playMp4(String fileName) {
//        System.out.println("play VLC name + "+fileName);

    }
}
