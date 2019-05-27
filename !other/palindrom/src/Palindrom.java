import java.util.Scanner;

public class Palindrom {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine(); // args[0]; //"I   like  programming  because   it's interesting and  perspectively.";
        System.out.println(sort(sentence));
    }

    private static String sort(String sentence) {
        StringBuilder newSentence = new StringBuilder();
        boolean space = false;
        for (int i = 0; i < sentence.length(); i++) {

            if (Character.isSpaceChar(sentence.charAt(i))) {
                if (space) {
                    continue;
                }
                space = true;
            } else {
                space = false;
            }
            newSentence.append(sentence.charAt(i));
        }

        return newSentence.toString();
    }
}
