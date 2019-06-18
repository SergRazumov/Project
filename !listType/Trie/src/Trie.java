import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Параметризированный класс дерева T т.к в нем находится объекты типа T отсюда все параметризовалось
 *
 * @param <T> тип объекта который хранится в узлах дерева
 */
public class Trie<T> {
    /**
     * Класс
     *
     * @param <T> тип объекта который хранится в узле дерева, он может быть и V т.к названия значения не имеет тип придет тот же
     */
    private static class Node<T> {
        T translations = null;
        List<Arc<T>> children = new ArrayList<>();
        /**
         * Метод который ищет есть ли данная буква в дуге
         *
         * @param letter буква которую ищем
         * @return возвращаем заданную букву, в случае неудачи null
         */
        private Arc<T> findArc(char letter) {
            for (Arc<T> child : children) {
                if (child.let == letter) return child;
            }
            return null;
        }
    }
    /**
     * Класс который содержит объект типа T и саму букву составляющая часть ключа
     *
     * @param <T> этот параметр может быть и V он транслируется из Node
     */
    private static class Arc<T> {
        char let;
        Node<T> node = new Node<>();

        public Arc(char let) {
            this.let = let;
        }
    }
    /**
     * Узел с параметром Т указывающий на узел
     */
    Node<T> root = new Node<>();

    /**
     * Добавляем слова как ветку в trie
     *
     * @param key         ключ который добавляем
     * @param translation объект который содержит информацию о ключе
     */
    public void add(String key, T translation) {
        Node<T> current = root;
        for (int i = 0; i < key.length(); i++) {
            Arc<T> arc = current.findArc(key.charAt(i));
            if (arc == null) {
                arc = new Arc<>(key.charAt(i));
                current.children.add(arc);
            }
            current = arc.node;
        }
        current.translations = translation;
    }

    public void put(String key, T translation) {
        put(root, translation, key);
    }


    private void put(Node<T> root, T translation, String key) {
        if (key.isEmpty()) {
            root.translations = translation;
            return;
        }
        Arc<T> arc = root.findArc(key.charAt(0));
        if (arc == null) {
            root.children.add(arc = new Arc<T>(key.charAt(0)));
        }
        put(arc.node, translation, key.substring(1));
    }

    /**
     * Метод который будет выводить все ключи с объектом
     */

    public void viewRoot() {
        viewRoot(root, "");
    }

    private void viewRoot(Node<T> current, String str) {
        if(current.translations!= null) {
            System.out.println(str + " " + current.translations);
        }
            for(Arc<T> child:current.children) {
                viewRoot(child.node, str+ child.let);
        }
    }
    /**
     * @param key ключ по которому возвращаем объект
     * @return возвращаем объект по заданному ключу, если не обнаружен null
     */

    public T get(String key) {
        Node<T> current = root;
        for (int i = 0; i < key.length(); i++) {
            Arc<T> arc = current.findArc(key.charAt(i));
            if (arc != null) {
                current = arc.node;
            } else return null;
        }
        return current.translations;
    }

    /**
     * Метод который удаляет объект и все дуги из дерева связанные с этим словом, не повреждая другие дуги и другие объекты.
     *
     * @param key слово которое удаляем
     * @return возвращаем удаленный объект или null если объект не обнаружен
     */
    public T remove(String key) {
        Node<T> current = root;
        Node<T> cross = root;
        Node<T> cut = null;
        for (int i = 0; i < key.length(); i++) {  // тот отрезок где будем работать, где cross это узел пересечения, cut узел следующий за ним в направлении объекта, current конечный узел
            Arc<T> arc = current.findArc(key.charAt(i));
            if (arc != null) {
                current = arc.node;
                if (cross.children.size() > 1) {
                    for (Arc<T> child : cross.children) {
                        if (child == arc) {
                            cut = arc.node;
                        }
                    }
                }
                if (current.children.size() > 1) {
                    cross = current;
                }
            } else return null;
        }

        for (Node<T> i = cut; !i.children.isEmpty(); i = i.children.get(0).node) {  // двигаем cut и оставляем там где был последний раз T!= null
            if (i.translations != null) {
                cut = i;
            }
        }
        for (Arc<T> c : cross.children) {
            if (c.node == current || (c.node == cut && cut.translations == null)) {// обрабатываем условие, если конечный объект сразу за перекрестком отрезаем, или если cut не перемещался и при этом в cut нет объекта это говорит о том, мы так же можем отрезать от перекрестка
                cross.children.remove(c);
                return current.translations;
            }
        }
        cut.children.clear(); // отрезаем все что после cut, если в данной ветке все таки нашлось слово (как с site)
        return current.translations;
    }

    private static class Result<T> {
        T result;
        boolean cut;

        public Result(T result, boolean cut) {
            this.result = result;
            this.cut = cut;
        }
    }

    public T delete(String key) {
        Result<T> result = delete(root, key);
        return result.result;
    }

    private Result<T> delete(Node<T> node, String key) {
        if (key.isEmpty()) {
            return new Result<>(node.translations, node.children.isEmpty());
        }
        Arc<T> arc = node.findArc(key.charAt(0));
        if (arc == null) return new Result<>(null, false);
        Result<T> result = delete(arc.node, key.substring(1));
        if (result.cut) node.children.remove(arc);
        return new Result<>(result.result, node.translations == null && node.children.isEmpty());
    }

}
