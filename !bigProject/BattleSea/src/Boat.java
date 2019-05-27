/**
 *
 */
public class Boat {
    private Direction dir;
    private int length, x, y;


    /**
     * Характеристика объекта корабль
     * @param x координата х на поле откуда строиться корабль
     * @param y координата у на поле откуда строиться корабль
     * @param dir его расположение вертикальное или горизонтальное
     * @param length его длина
     */
    public Boat(int x, int y, Direction dir, int length) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.length = length;

    }

    /**
     * Изменяет статус ячеек на NEAR где должен стоять корабль и рядом с ним
     * @param x координата х части корабля
     * @param y координата у части корабля
     * @param state текущий статус ячейки
     */
    private void addEmpty(int x, int y, State state) {
        for (int i = x-1; i<=x+1; i++)
            for (int j = y-1; j <= y+1; j++)
                if (i>=0 && i <=9 && j>=0 && j<=9)
                    Space.SPACE.cells[i][j].setState(state);
    }

    /**
     * Добавляем корабль на поле и организуем связь ячейки поля на данный добавленный корабль
     * @return
     */
    boolean cross() {
        int dx = 0, dy = 0;

        if (dir == Direction.VERT) {
            dy = 1;
        } else {
            dx = 1;
        }
        for (int i = 0; i < length; i++) {
            if (!(Space.SPACE.cells[x][y].getState().equals(State.EMPTY))) {
                return true;
            }
            x += dx;
            y += dy;
        }
        for (int i = 0; i < length; i++) {
            x -= dx;
            y -= dy;
            addEmpty(x, y, State.NEAR);
        }
        for (int i = 0; i < length; i++) {
            Space.SPACE.cells[x + i*dx][y + i*dy].setState(State.BOAT);
            Space.SPACE.cells[x + i*dx][y + i*dy].setBoat(this); // тут я вроде выполняю присваивание каждой ячейке к кораблям Boat[k]
        }
        return false;
    }

    /**
     * Метод выполняется если корабль уничтожен, изменяет статусы ячеек и помечает поле вокруг
     */
    public void destroy() {
        int dx = 0, dy = 0;
        if (dir == Direction.VERT) {
            dy = 1;
        } else {
            dx = 1;
        }
        for(int i=0; i < length; i++) {
            addEmpty(x + i*dx,y + i*dy,State.SHOT);
        }
        for(int i=0; i < length; i++) {
            Space.SPACE.cells[x + i*dx][y + i*dy].setState(State.DESTROYED);
        }

        // Ну, и кругом корабля тоже надо расставить State.SHOT
    }

    /**
     * В случае попадания метод проверяет все ли ячейки имеют статус HIT (попал)
     * @return
     */
    public boolean destroyed() {
        int dx = 0, dy = 0;
        if (dir == Direction.VERT) {
            dy = 1;
        } else {
            dx = 1;
        }
        for(int i=0; i < length; i++) {
            if (Space.SPACE.cells[x + i*dx][y + i*dy].getState() != State.HIT) {
                return false;
            }
        }
        return true;
    }
}


