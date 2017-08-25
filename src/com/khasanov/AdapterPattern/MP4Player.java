package com.khasanov.AdapterPattern;

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
//        System.out.println("play VLC name + "+fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("play mp4 name + "+fileName);

    }
}
