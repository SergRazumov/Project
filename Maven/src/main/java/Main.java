import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Анотации
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(City.class);
        City city1 = applicationContext.getBean(City.class);
        city1.sayHello();

        //XML
       applicationContext = new ClassPathXmlApplicationContext("configFile.xml");
       System.out.println(city1.getName());
    }
}
