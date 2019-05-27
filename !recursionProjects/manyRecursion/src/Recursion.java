import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("Дано натуральное число n. Выведите все числа от 1 до n " + " " + viewNaturalNumber(5));
        System.out.println(" Даны два целых числа A и В (каждое в отдельной строке). Выведите все числа от A до B включительно, в порядке возрастания, если A < B, или в порядке убывания в противном случае." + numbers(10, 5));
        System.out.println(power(2, 10));
        System.out.println("Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки, или слово NO в противном случае.");
        System.out.println(powerTwo(10));
        System.out.println("Дано натуральное число N. Вычислите сумму его цифр");
        System.out.println(summaNumber(1585));
        System.out.println("Дано натуральное число N. Выведите все его цифры по одной, в обратном порядке, разделяя их пробелами или новыми строками.");
        System.out.println(poliformNumber(563));
        System.out.println(poliformNumberInt(563));
        System.out.println("Дано натуральное число n>1. Проверьте, является ли оно простым. Программа должна вывести слово YES, если число простое и NO, если число составное. Алгоритм должен иметь сложность O(logn).\n" +
                "Указание. Понятно, что задача сама по себе нерекурсивна, т.к. проверка числа n на простоту никак не сводится к проверке на простоту меньших чисел. Поэтому нужно сделать еще один параметр рекурсии: делитель числа, и именно по этому параметру и делать рекурсию.");
        System.out.println(primeNumber(3));
        System.out.println("Дано натуральное число n>1. Выведите все простые множители этого числа в порядке возрастания с учетом кратности. Алгоритм должен иметь сложность O(logn).");
        System.out.println(factorsNumber(75));
        System.out.println("Дано слово, состоящее только из строчных латинских букв. Проверьте, является ли это слово палиндромом. Выведите YES или NO.");
        System.out.println(polindrom("Ан3на"));
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Выведите все нечетные числа из этой последовательности, сохраняя их порядок.");
        System.out.println(listNaturalNumber("1234567890"));
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Выведите первое, третье, пятое и т.д. из введенных чисел. Завершающий ноль выводить не надо.");
        System.out.println(oddNumbers("1234567890"));
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите наибольшее значение числа в этой последовательности.");
        System.out.println(maxNumber("1234564340"));
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите среднее значение элементов этой последовательности (без учета последнего нуля).\n" +
                "В этой задаче нельзя использовать глобальные переменные. Функция получает данные, считывая их с клавиатуры, а не получая их в виде параметра.\n" +
                "Гарантируется, что последовательность содержит хотя бы одно число (кроме нуля).");
        System.out.println(averageNumbers());
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите значение второго по величине элемента в этой последовательности, то есть элемента, который будет наибольшим, если из последовательности удалить наибольший элемент.\n" +
                "В этой задаче нельзя использовать глобальные переменные. Функция получает данные, считывая их с клавиатуры, а не получая их в виде параметра.\n" +
                "Других параметров, кроме как используемых для возврата значения, функция не получает.");
        System.out.println(averageNumbersTwo());
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0. Определите, какое количество элементов этой последовательности, равны ее наибольшему элементу.");
        System.out.println(quantityElements());
        System.out.println("Дана последовательность натуральных чисел (одно число в строке), завершающаяся двумя числами 0 подряд. Определите, сколько раз в этой последовательности встречается число 1. Числа, идущие после двух нулей, необходимо игнорировать.");
        System.out.println(countOne());
        System.out.println("Дана монотонная последовательность, в которой каждое натуральное число k встречается ровно k раз: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4,…\n" +
                "По данному натуральному n выведите все числа до него.");
        System.out.println(nNumber());
        System.out.println("Даны натуральные числа k и s. Определите, сколько существует k-значных натуральных чисел, сумма цифр которых равна d. Запись натурального числа не может начинаться с цифры 0.\n" +
                "В этой задаче можно использовать цикл для перебора всех цифр, стоящих на какой-либо позиции.");
        System.out.println();


    }


    private static String nNumber() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        return nNumber(n);
    }

    private static String nNumber(int n) { // как перевернуть*?
        if(n ==1) return "1 ";
        StringBuilder sb = new StringBuilder(nNumber(n-1));
        for (int i = 0; i < n; i++) {
            sb.append(n+" ");
        }
        return sb.toString();
    }


    private static int countOne() {
        String line = "5, 14, 16, 11, 16, 7, 14, 10";
        int count = 0;
        List<Integer> listInt = new ArrayList<>();
        Pattern numbers = Pattern.compile("([0-99]),*\\s*");
        Matcher n = numbers.matcher(line);
        int index = 0;
        while (n.find(index)) {
            listInt.add(Integer.valueOf(n.group(1)));
            index = n.end();
        }
        return countOne(listInt, listInt.size(), count);
    }

    private static int countOne(List<Integer> listInt, int size, int count) {
        if(size == 0) return count;
        if(listInt.get(size-1).equals(1)) count++;
        return countOne(listInt, size-1, count);
    }

    private static int quantityElements() {
        String line = "5, 14, 16, 11, 16, 7, 14, 10";
        int count = 0; int max = 0;
        List<Integer> listInt = new ArrayList<>();
        Pattern numbers = Pattern.compile("([1-99]+),*\\s*");
        Matcher n = numbers.matcher(line);
        int index = 0;
        while (n.find(index)) {
            listInt.add(Integer.valueOf(n.group(1)));
            index = n.end();
        }
        return quantityElements(listInt, listInt.size(), count, max);
    }

    private static int quantityElements(List<Integer> listInt, int size, int count, int max) {
        if(size == 0) return count+1;
        if(max == listInt.get(size-1)) count++;
        if(listInt.get(size-1) > max) max = listInt.get(size-1);
        return quantityElements(listInt, size-1, count, max);
    }

    private static int averageNumbersTwo() {
        String line = "5, 14, 8, 11, 16, 7, 12";
        List<Integer> listInt = new ArrayList<>();
        int min = 0, max = 0;
        Pattern numbers = Pattern.compile("([1-99]+),*\\s*");
        Matcher n = numbers.matcher(line);
        int index = 0;
        while (n.find(index)) {
            listInt.add(Integer.valueOf(n.group(1)));
            index = n.end();
        }
        if (listInt.get(0) < listInt.get(1)) {
            min = listInt.get(0);
            max = listInt.get(1);
        } else {
            min = listInt.get(1);
            max = listInt.get(0);
        }
        return averageNumbersTwo(listInt, min, max, listInt.size());
    }

    private static int averageNumbersTwo(List<Integer> listInt, int min, int max, int size) {
        if(size == 2) return min;
        if(listInt.get(size-1) > max) { min = max; max = listInt.get(size-1); }
        if(listInt.get(size-1) > min && listInt.get(size-1) != max) min = listInt.get(size-1);
        return averageNumbersTwo(listInt, min, max, size-1);
    }

    private static int averageNumbers() {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        List<Integer> massNum = new ArrayList<>();
        int average = 0;
        if (numbers.isEmpty()) return 0;
        for (int i = 0; i < numbers.length(); i++) {
            massNum.add(numbers.charAt(i) - '0');
        }

        return averageNumbers(massNum, massNum.size(), average);
    }


    private static int averageNumbers(List<Integer> massNum, int size, int average) {
        if (size == 1) return (average + massNum.get(0)) / 2;
        if (size > 1) {
            average += massNum.get(size - 1);
        }
        return averageNumbers(massNum, size - 1, average);
    }


    private static int maxNumber(String numbers) {
        if (numbers.isEmpty()) return 0;
        int max = 0;
        return maxNumber(numbers, numbers.length(), max);
    }

    private static int maxNumber(String num, int length, int max) {
        if (length == 1) if (num.charAt(0) - '0' < max) return max;
        else return num.charAt(0) - '0';
        if (num.charAt(length - 1) - '0' > max) {
            max = num.charAt(length - 1) - '0';
        }
        return maxNumber(num, length - 1, max);
    }

    private static String oddNumbers(String numbers) { // добавлено
        if (numbers.isEmpty()) return "";
        return oddNumbers(numbers, numbers.length());
    }

    private static String oddNumbers(String num, int length) {
        if (length == 1) return String.valueOf(num.charAt(length - 1));
        if (num.indexOf(num.charAt(length - 1)) % 2 == 0 && num.charAt(length - 1) != '0')
            return oddNumbers(num, length - 1) + num.charAt(length - 1);
        else return oddNumbers(num, length - 1);
    }


    private static String listNaturalNumber(String numbers) {
        return listNaturalNumber(numbers, numbers.length());
    }

    private static String listNaturalNumber(String num, int length) {
        if (length == 0) return "";
        if (length == 1 && num.charAt(length - 1) % 2 != 0) return String.valueOf(num.charAt(length - 1));
        if (num.charAt(length - 1) % 2 != 0) {
            int nun = Integer.valueOf(length - 1);
            return listNaturalNumber(num, length - 1) + num.charAt(nun);
        } else return listNaturalNumber(num, length - 1);
    }


    private static boolean polindrom(String word) {
        word = word.toLowerCase();
        return polindrom(word, 0, word.length());
    }

    private static boolean polindrom(String word, int low, int high) {
        if (high == 0 && word.length() % 2 == 1) return false;
        if (low == high) return true;
        if (word.charAt(low) == word.charAt(high - 1))
            return polindrom(word, low + 1, high - 1);
        else return false;
    }

    private static String factorsNumber(int n) {
        return factorsNumber(n, 2);
    }

    private static String factorsNumber(int n, int d) {
        if (n == d || n < d * d) return String.valueOf(n);
        if (n % d == 0) {
            return d + " " + factorsNumber(n / d, d);
        } else
            d++;
        while (!primeNumber(d)) {
            d++;
        }
        return factorsNumber(n, d);
    }

    private static boolean primeNumber(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        else return primeNumber(n, 3);

    }

    private static boolean primeNumber(int n, int d) {
        if (n % d == 0 && n != d)
            return false; // тут поправил добавив условие, n!=d иначе при числе 3 выдавало что это составное число.
        if (n < d * d) return true;
        return primeNumber(n, d + 2);
    }

    private static int poliformNumberInt(int n) {
        if (n < 10) return n;
        return n % 10 * nullNumber(n) + poliformNumberInt(n / 10);
    }

    private static int nullNumber(int n) {
        if (n < 10) return 1;
        return nullNumber(n / 10) * 10;
    }

    private static String poliformNumber(int n) {
        if (n < 10) return String.valueOf(n);
        return n % 10 + " " + poliformNumber(n / 10);
    }

    private static int summaNumber(int n) {
        if (n < 10) return n;
        return summaNumber(n / 10) + n % 10;
    }

    private static boolean powerTwo(int n) {
        if (n == 1) return true;
        if (n % 2 == 1) return false;
        return powerTwo(n / 2);
    }


    private static String viewNaturalNumber(int n) {
        if (n == 1) return "1";
        return viewNaturalNumber(n - 1) + n;

    }

    private static String numbers(int a, int b) {
        if (a == b) return String.valueOf(a);
        if (a < b) return a + numbers(a + 1, b);
        else return a + numbers(a - 1, b);
    }

    private static int power(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 1) {
            return power(a, b - 1) * a;
        } else {
            int p = power(a, b / 2);
            return p * p;
        }
    }
}