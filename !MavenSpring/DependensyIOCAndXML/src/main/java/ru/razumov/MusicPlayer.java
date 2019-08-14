package ru.razumov;



import java.util.List;

public class MusicPlayer {

    private List<Music> music;
    private String namePlayer;
    private int value;
    private Music mus;
    
    public MusicPlayer(List<Music> music) {
        this.music = music;
        sound();
    }

    private void runInitMethod() {
        System.out.println("Проверка запуска init-метода класс MusicPlayer");
    }

    private void runDestroyMethod() {
        System.out.println("Проверка запуска destroy-метода класс MusicPlayer");
    }

    private void sound() {
        for(Music music: music) {
            music.sound();
        }
    }


    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void setMus(Music mus) {
        mus.sound();
        this.mus = mus;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public int getValue() {
        return value;
    }
}
