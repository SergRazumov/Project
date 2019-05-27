import java.util.Scanner;

public class Numbers {
    public static void main (String args[]) {
        Scanner in = new Scanner("3 5 2 9");
        System.out.println("Введите числитель ");
        int h = in.nextInt();
        System.out.println("Введите знаменатель ");
        int l = in.nextInt();
        Fraction f1 = new Fraction(h, l);
        System.out.println("Введите второй числитель ");
        int h1 = in.nextInt();
        System.out.println("Введите второй знаменатель ");
        int l1 = in.nextInt();
        Fraction f2 = new Fraction(h1, l1);

        Fraction f3 = f1.add(Fraction.UNIT);
        Fraction f4 = new Fraction(2, 9);
        Fraction f5 = f3.add(f4);

        Factional num = new Factional(h,l,h1,l1);
        num.sum();
        System.out.println("Сумма двух дробей равно " + num.toString());
        System.out.println("Разность двух дробей равно " + num.toString());
        System.out.println("Частность двух дробей равно  " + num.toString());
        num.composition();
        System.out.println("Произведение двух дробей равно " + num.toString());

    }
}
