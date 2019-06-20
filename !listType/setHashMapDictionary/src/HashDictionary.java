import java.util.*;

/**
 * Реализация интерфейса Dictionary, основанная на использовании своей hash-таблицы слов. Словарь предполагается
 * не сортированным, итерация слов - в неупорядоченном виде.
 */
public class HashDictionary implements Dictionary {
    /**
     * Hash-таблица из (неупорядоченных) списков слов с одним и тем же значением hash-кода
     */
    private List<String>[] hashTable = new List[100];

    @Override
    public boolean add(String word) {
        int index = myHash(word);
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
            hashTable[index].add(word.toLowerCase());
            return true;
        } else if (hashTable[index].contains(word.toLowerCase())) {
            return false;
        }
        hashTable[index].add(word.toLowerCase());
        return true;
    }

    @Override
    public boolean contains(String word) {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        List<String> element = hashTable[myHash(word)];
        if (element == null) return false;
        else {
            return element.contains(word.toLowerCase());
        }
    }

    @Override
    public boolean remove(String word) {
        List<String> element = hashTable[myHash(word)];
        if (element != null) {
            return element.remove(word.toLowerCase());
        } else
            return false;
    }

    @Override
    public Iterator<String> iterator() {
        // TODO: Это всего лишь "заглушка" - заменить на рабочеее тело метода
        return new Iterator<>() {
            private int listCnt;
            private Iterator<String> wordIter;

            {
                findNext();
            }

            private void findNext() {
                while (listCnt < hashTable.length &&
                        (hashTable[listCnt] == null || hashTable[listCnt].isEmpty())) {
                    listCnt++;
                }
                if (listCnt < hashTable.length) {
                    wordIter = hashTable[listCnt].iterator();
                }
            }

            @Override
            public boolean hasNext() {
                return hashTable.length != listCnt;
            }

            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                String result = wordIter.next();
                if (!wordIter.hasNext()) {
                    listCnt++;
                    findNext();
                }
                return result;
            }

        };
    }

    private int myHash(String s) {
        return Math.abs(s.toLowerCase().hashCode()) % 100;
    }


    public class DictIterator implements Iterator<String> {
        private int listCnt;
        private Iterator<String> wordIter;

        DictIterator() {
            findNext();
        }

        private void findNext() {
            while (listCnt < hashTable.length &&
                    (hashTable[listCnt] == null || hashTable[listCnt].isEmpty())) {
                listCnt++;
            }
            if (listCnt < hashTable.length) {
                wordIter = hashTable[listCnt].iterator();
            }
        }

        @Override
        public boolean hasNext() {
            return hashTable.length != listCnt;
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String result = wordIter.next();
            if (!wordIter.hasNext()) {
                listCnt++;
                findNext();
            }
            return result;
        }
    }
}

