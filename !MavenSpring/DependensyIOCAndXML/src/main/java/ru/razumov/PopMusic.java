package ru.razumov;

public class PopMusic implements Music {

    public static PopMusic getPopMusic() {
        return new PopMusic();
    }

    public void sound() {
        System.out.println("Играет поп музыка ");
    }

}
