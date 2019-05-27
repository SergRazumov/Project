public class Ex6 {
    public static void main(String args[]) {
        String sentence = " I was born in Norilsk!";
        int words = 1;
        for (int i =0; i<sentence.length(); i++) {
            if(Character.isSpaceChar(sentence.charAt(i))) words++;
        }
        System.out.print("В данном предложении " + words + " слов");
    }
}
