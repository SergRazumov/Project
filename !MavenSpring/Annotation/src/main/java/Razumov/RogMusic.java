package Razumov;
import org.springframework.stereotype.Component;

@Component
public class RogMusic implements Music {
    public void sound() {
        System.out.println("Играет рок музыка ");
    }

}
