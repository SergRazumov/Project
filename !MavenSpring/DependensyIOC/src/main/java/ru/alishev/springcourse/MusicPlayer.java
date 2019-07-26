package ru.alishev.springcourse;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

   private Music music;
   private String nameInstrument;
   private int countInstruments;
    private List<Music> listMusic = new ArrayList<Music>();

    public void doMyInit() {
        System.out.println("Start ");
    }

    public void doMyDestroy() {
        System.out.println("End ");
    }


    public MusicPlayer() {}

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void setNameInstrument(String nameInstrument) {
        this.nameInstrument = nameInstrument;
    }

    public void setListMusic(List<Music> list) {
        listMusic = list;
        for(Music music: list) {
            music.getSound();
        }
    }

    public void setCountInstruments(int countInstruments) {
        this.countInstruments = countInstruments;
    }

    public void getSound() {
        System.out.println("Играет музыка ");
        music.getSound();
    }

    public void setMusic(Music music) {
        music.getSound();
    }
}
