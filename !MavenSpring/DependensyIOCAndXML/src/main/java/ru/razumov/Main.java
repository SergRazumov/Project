package ru.razumov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //XML
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configFile.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer" ,MusicPlayer.class);
        System.out.println("Название устройства: " + musicPlayer.getNamePlayer());
        System.out.println("Громкость: " + musicPlayer.getValue());

        ClassicMusic classicMusic1 = context.getBean("ClassicalBean", ClassicMusic.class);
        ClassicMusic classicMusic2 = context.getBean("ClassicalBean", ClassicMusic.class);
        if(classicMusic1!=classicMusic2) System.out.println("Это prototype ");
        context.close();
    }
}
