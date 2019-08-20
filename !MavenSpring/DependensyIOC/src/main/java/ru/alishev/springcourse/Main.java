package ru.alishev.springcourse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configFile.xml");
        System.out.println("hhh");
       // MusicPlayer musicPlayer = context.getBean("Player", MusicPlayer.class);
      //  Music music = context.getBean("classicalBean", ClassicalMusic.class);
       // music.getSound();
    }
}
