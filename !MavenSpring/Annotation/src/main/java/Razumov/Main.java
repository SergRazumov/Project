package Razumov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //XML
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configFile.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer" ,MusicPlayer.class);
        context.close();
    }
}
