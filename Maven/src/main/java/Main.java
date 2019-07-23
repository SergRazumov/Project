import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Анотации
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(City.class);
        City city1 = applicationContext.getBean(City.class);
        city1.sayHello();

        //XML
       applicationContext = new ClassPathXmlApplicationContext("configFile.xml");
       City city2 = applicationContext.getBean(City.class);
       System.out.println(city2.getName());
        MyMap myMap = applicationContext.getBean(MyMap.class);
        Method method = myMap.getClass().getMethod("addValue", null);
        method.invoke(myMap, null);
    }

}
