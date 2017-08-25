package com.khasanov.AdapterPattern;

public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","jonim.mp3");
        audioPlayer.play("mp4","kino.mp4");
        audioPlayer.play("vlc","ubuntuKino.vlc");
    }
}
