import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private static class A {}

    MyList<Integer> listInt;
    MyList<String> listStr;
    MyList<A> listA;

    @BeforeEach
    void setUp() {
        listInt = new MyList<>();
        listStr = new MyList<>();
        listA = new MyList<>();
        for (int i = 0; i < 10; i++) {
            listInt.add(10-i);              // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            listStr.add("Str " + (10-i));   // [Str 1, Str 2, Str 3, Str 4, Str 5, Str 6, Str 7, Str 8, Str 9, Str 10]
            listA.add(new A());             // ??
        }
    }

    // Тесты, которые проходят

    @Test
    void testReverse() {
        int size = listStr.size();
        String last = "Str 10";
        listStr.reverse();
        assertEquals(size, listStr.size());
        assertEquals(last, listStr.get(0));
    }

    @Test
    void testInsert() {
        listInt.insert(3, 10);
        assertEquals(Integer.valueOf(10), listInt.get(3));
        listStr.insert(0, "");
        assertEquals("", listStr.get(0));
        listA.insert(10, new A());
        assertEquals(11, listA.size());
    }

    @Test
    void testToString() {
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", listInt.toString());
        assertEquals("[Str 1, Str 2, Str 3, Str 4, Str 5, Str 6, Str 7, Str 8, Str 9, Str 10]", listStr.toString());
    }

    // Тесты, которые ломаются...

    @Test
    void testLast() {
        assertEquals(Integer.valueOf(10), listInt.last());
        assertEquals("Str 10", listStr.last());
    }

    @Test
    void testSize() {
        assertEquals(10, listA.size());
        assertEquals(0, new MyList<Double>().size());
    }

    @Test
    void testRemove() {
        for (int size = 9; size >=0; size--) {
            assertEquals(size+1, listA.size());
            listA.remove(size);
        }
        listA.add(new A());
        assertEquals(1, listA.size());
    }

    @Test
    void testFind() {
        assertEquals(2, listInt.find(3));
        assertEquals(2, listStr.find("Str 3"));
        assertEquals(-1, listStr.find("Str 0"));
        assertEquals(-1, listA.find(new A()));
    }

    @Test
    void testGet() {
        assertEquals(Integer.valueOf(1), listInt.get(0));
        assertEquals("Str 10", listStr.get(9));
        try {
            A objA = listA.get(10);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Неверный индекс в списке 10", e.getMessage());
        }
    }
}