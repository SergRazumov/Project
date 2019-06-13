public class Translation {

    private String word;
    private int letter;


    Translation(String word, int letter) {
        this.word = word;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return  "word='" + word + '\'' +
                ", letter=" + letter;
    }
}
