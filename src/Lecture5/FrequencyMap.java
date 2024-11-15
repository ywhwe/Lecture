package src.Lecture5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyMap {
    void run() {
        Map<String, Integer> map;
        List<String> words = CollectionTestUtil.collectWords("jobs.txt");

        map = freqMap(words);

        CollectionTestUtil.printLn(map.entrySet(), 5);
    }

    public Map<String, Integer> freqMap(List<String> words) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        CollectionTestUtil.printLn(map.entrySet(), 5);
        System.out.println();

        map.keySet().removeIf(x -> x.length() <= 1);
        map.values().removeIf(x -> x <= 1);

        /*for (String word : words) {
            if (map.get(word) != null) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }*/

        return map;
    }

    public static void main(String[] args) {
        FrequencyMap fm = new FrequencyMap();
        fm.run();
    }
}
