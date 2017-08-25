package com.khasanov.AdapterPattern;

public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if (! audioType.equalsIgnoreCase("mp3")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);

        }else {
            System.out.println("play mp3 name + "+fileName);

        }
    }
}
