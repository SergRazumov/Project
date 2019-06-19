public class HashMain {
    public static void main(String[] args) {

        MyHashMap.myHashMap.put("ONE" , 5);
        MyHashMap.myHashMap.put("TWO" , 10);
        MyHashMap.myHashMap.put("THREE" , 8);
        MyHashMap.myHashMap.put("FOUR" , 12);
        MyHashMap.myHashMap.put("FIVE" , 3);
        MyHashMap.myHashMap.put("ONE" , 7);

        for(Elem<String, Integer> elem:MyHashMap.myHashMap) { //почему Object;
         System.out.print(elem);

        }
        }
    }

