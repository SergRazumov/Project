/**
 * Словарь - это множество слов. Одна из возможных реализаций может быть основана на Set<String>, другая
 * возможность - реализовать самому HashDictionary и/или SortedDictionary
 */
public interface Dictionary extends Iterable<String> {
    /** Добавляет слово в словарь. Выдает false, если это новое слово, и true, если слово уже было в словаре */
    boolean add(String word);
    /** Проверяет, есть ли заданное слово в словаре */
    boolean contains(String word);
    /** Удаляет заданное слово из словаря. Выдает true, если слово было в словаре, и false, если его там и не было */
    boolean remove(String word);
}
