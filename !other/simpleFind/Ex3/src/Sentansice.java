public class Sentansice {
    public static void main(String args[]) {
        String a = "My name is Sergey!";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<a.length(); i++) {
            sb.append(Character.isSpaceChar(a.charAt(i)) ? '.' : a.charAt(i));
        }
        System.out.println(sb);

    }
}
