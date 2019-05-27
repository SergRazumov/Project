public class Space {

    final static Space SPACE = new Space();
    Cell[][] cells = new Cell[10][10];

    /**
     * Конструктор создает поле из ячеек
     */
    private Space() {
        int i = 0, j = 0;
        for (Width width : Width.values()) {
            for (Height height : Height.values()) {
                cells[i++][j] = new Cell(width, height);
            }
            j++;
            i = 0;
        }
    }

    public static void main(String[] args) {
       for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(SPACE.cells[i][j].toString() + "  ");
            }
            System.out.println();
        }
    }
}