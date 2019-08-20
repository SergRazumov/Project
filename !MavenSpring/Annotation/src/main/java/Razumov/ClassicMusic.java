package Razumov;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music {

    public void sound() {

        System.out.println("Играет классическая музыка ");
    }
}
