import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Реализация интерфейса Dictionary, основанная на использовании упорядоченного списка слов. Словарь предполагается
 * сортированным, итерация слов - в алфавитном порядке.
 */
public class SortedDictionary implements Dictionary {
    /**
     * Упорядоченный список слов. Поддерживается алфавитный порядок слов, так что поиск
     * можно производить с помощью двоичного поиска в массиве.
     */
    private List<String> wordList = new ArrayList<>();

    @Override
    public boolean add(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        word = word.toLowerCase();
        ListIterator<String> iterator = wordList.listIterator();
        String currentWord = null;
        while(iterator.hasNext() && (currentWord = iterator.next()).compareTo(word) < 0) ;
        if (!iterator.hasNext()) {
            wordList.add(word);
            return true;
        } else if (currentWord.equals(word)) {
            return false;
        } else {
            iterator.previous();
            iterator.add(word);
        }
        return true;
    }

    @Override
    public boolean contains(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return wordList.contains(word.toLowerCase());
    }

    @Override
    public boolean remove(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return wordList.remove(word.toLowerCase());
    }

    @Override
    public Iterator<String> iterator() {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return wordList.iterator();
    }
}
