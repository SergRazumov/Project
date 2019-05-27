public class Dots {
    public static void main(String[] args) {
        String a = "This is world!";
        char[] b = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isSpaceChar(c)) {
                b[i] = '.';
            } else {
                b[i] = c;
            }
        }
        String res = new String(b);
        System.out.println(res);
    }
}
