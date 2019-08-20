package Razumov;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
@Component
@Scope("singleton")
public class MusicPlayer {

    private List<Music> music;
    private String namePlayer;
    private int value;
    private Music mus;

    @Autowired
    public MusicPlayer(List<Music> music) {
        this.music = music;
        sound();
    }

    public MusicPlayer() {}

    public void run() { System.out.println("Класс MusicPlayer создан ");}

    @PostConstruct
    private void runInitMethod() {
        System.out.println("Проверка запуска init-метода класс MusicPlayer");
    }

    @PreDestroy
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
    @Value("${value}")
    public void setValue(int value) {
        this.value = value;
    }

    @Autowired
    @Qualifier("rogMusic")
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
