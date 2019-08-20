import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        Class<Example> myClass = Example.class;
        String nameClass = myClass.getName();
        System.out.println("Имя класса " + nameClass);
        int modifyClass = myClass.getModifiers();
        System.out.println("Abstact? " + Modifier.isAbstract(modifyClass));
        System.out.println("Final? " +Modifier.isFinal(modifyClass));
        System.out.println("Interface? " + Modifier.isInterface(modifyClass));
        System.out.println("Native? " + Modifier.isNative(modifyClass));
        System.out.println("Private? " + Modifier.isPrivate(modifyClass));
        System.out.println("Protect? " + Modifier.isProtected(modifyClass));
        System.out.println("Public? " + Modifier.isPublic(modifyClass));
        System.out.println("Static? " + Modifier.isStatic(modifyClass));
        System.out.println("Strict? " + Modifier.isStrict(modifyClass));
        System.out.println("Synchronized? " + Modifier.isSynchronized(modifyClass));
        System.out.println("Transient " + Modifier.isTransient(modifyClass));
        System.out.println("Volatile? " + Modifier.isVolatile(modifyClass));
        Package myPackage = myClass.getPackage();
        Class superClass = myClass.getSuperclass();
        Class []myInterface = myClass.getInterfaces();
        Class []myInterfaceSuperClass = superClass.getInterfaces();

        try {
            Constructor []myConstructors = myClass.getConstructors(); // получаем массив конструкторов класса
            Constructor myConstructor = Example.class.getConstructor(String.class); // ссылка на конструктор с параметром String
            Class []parameterTypes = myConstructors[2].getParameterTypes(); // получаем типы параметров какого-то конструктора
            Example exMyExampleCopy = (Example) myConstructor.newInstance("check"); // созд. экземляра класса с значением конструктора String
            Example newExampleCopy = (Example) myConstructors[2].newInstance(777); // созд. экземляра класса с значением конструктора 777, выбор из списка конструкторов

            Field[] myField = myClass.getFields(); // каждый эл. массива содержит экземляр поля public
            myField = myClass.getDeclaredFields(); // каждый эл. массива содержит экземляр поля private
            myField[0].setAccessible(true); // отключает проверку доступа для указанного поля. Теперь мы можем работать с ним с помощью рефлексии, даже если у него был private, protected или default доступ.
            Field myField2 = myClass.getField("randomVal");// получение доступа к полю по имени
            String fieldName = myField2.getName(); // получить имя поля
            Object fieldType = myField2.getType(); // получить тип поля

            Example instance = new Example(); // создаем экземляр который создает значения полей
            Object value = myField2.get(instance); // получаем значение поля по имени randomVal с учетом созд объекта
            myField2.set(instance, 7); // меняем значение у поля с именем randomVal в экземляре с именем instance на 7
            System.out.print(myField2.get(instance)); // проверяем изменилось ли значение

            Method []metods = myClass.getMethods(); // каждый эл. массива содержит по методу в классе Example
            Method method = myClass.getMethod("setLine", String.class); // получаем метод с именем setLine и принимаемым параметром String
            Class []parameterType = method.getParameterTypes(); // получить параметры метода
            Class returnType = method.getReturnType(); // получить тип возвращаемое значения
            method = Example.class.getDeclaredMethod("setValue", parameterType); // можно private, получаем метод с именем setValue
            method.invoke(instance, 10); // вызов метода setValue через экземляр с именем  instance и передача значения 10




        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        try {
            Class myClass2 = Class.forName("MyInterface");
            String nameClass2 = myClass2.getName();
            System.out.println("\nИмя класса " + nameClass2);
            int modifyClass2 = myClass2.getModifiers();
            System.out.println("Abstact? " + Modifier.isAbstract(modifyClass2));
            System.out.println("Final? " +Modifier.isFinal(modifyClass2));
            System.out.println("Interface? " + Modifier.isInterface(modifyClass2));
            System.out.println("Native? " + Modifier.isNative(modifyClass2));
            System.out.println("Private? " + Modifier.isPrivate(modifyClass2));
            System.out.println("Protect? " + Modifier.isProtected(modifyClass2));
            System.out.println("Public? " + Modifier.isPublic(modifyClass2));
            System.out.println("Static? " + Modifier.isStatic(modifyClass2));
            System.out.println("Strict? " + Modifier.isStrict(modifyClass2));
            System.out.println("Synchronized? " + Modifier.isSynchronized(modifyClass2));
            System.out.println("Transient " + Modifier.isTransient(modifyClass2));
            System.out.println("Volatile? " + Modifier.isVolatile(modifyClass2));
            Package myPackage2 = myClass2.getPackage();
            Class superClass2 = myClass2.getSuperclass();
            Class []myInterface2 = myClass2.getInterfaces();
            Constructor []myConstructor2 = myClass2.getConstructors();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void printGettersOrSetters(Class aClass){
        Method[] methods = aClass.getMethods();

        for(Method method : methods){
            if(isGetter(method)) System.out.println("getter: " + method);
            if(isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }

        return true;
    }

    public static boolean isSetter(Method method){
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}
