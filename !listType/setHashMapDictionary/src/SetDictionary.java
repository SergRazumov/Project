import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Реализация интерфейса Dictionary, основанная на использования сортированного множества слов
 */
public class SetDictionary implements Dictionary {
    /**
     * Упорядоченное множество слов
     */

    private TreeSet<String> baseSet = new TreeSet<>();

    @Override
    public boolean add(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return baseSet.add(word.toLowerCase());
    }

    @Override
    public boolean contains(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return baseSet.contains(word.toLowerCase());
    }

    @Override
    public boolean remove(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return baseSet.remove(word.toLowerCase());
    }

    @Override
    public Iterator<String> iterator() {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return baseSet.iterator();
    }
}
