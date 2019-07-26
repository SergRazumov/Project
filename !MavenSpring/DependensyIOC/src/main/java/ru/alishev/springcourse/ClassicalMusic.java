package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

@Component("classicalBean")
public class ClassicalMusic implements Music {

//    MusicPlayer musicPlayer;
//
//    public ClassicalMusic(MusicPlayer musicPlayer) {
//        this.musicPlayer = musicPlayer;
//    }

    public void getSound() {
        System.out.println("Играет классическая музыка ");
    }
}
