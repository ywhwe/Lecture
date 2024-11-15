package src.Lecture5;

import java.util.*;

public class CollTest {

    void run() {
        /*Collection<Integer> c1 = CollectionTestUtil.fillNumbers(10);
        Collection<Integer> c2 = CollectionTestUtil.fillNumbers(10);

        System.out.println(c1);
        System.out.println(c2);

        c1.addAll(c2);
        System.out.println("합: " + c1);
        c1.removeAll(c2);
        System.out.println("차: " + c1);*/
        Random rand = new Random();

        Collection<Integer> c = new ArrayList<>();
        Set<Integer> randSet = new HashSet<>();
        int n;

        for (int i = 0; i < 30; i++) {
            n = rand.nextInt(30);
            randSet.add(n);
            c.add(i);
        }

        System.out.println("난수집합: " + randSet);
        c.removeAll(randSet); // 벌크 연산
        System.out.println("중복제외집합: " + c);
    }

    void runSet() {
        Collection<Integer> c = CollectionTestUtil.fillNumbers(10);
        Set<Integer> noo = new HashSet<>(c);
        System.out.println(c);
        System.out.println("HashSet: " + noo);
        noo = new TreeSet<>(c);
        System.out.println("TreeSet: " + noo);
        noo = new LinkedHashSet<>(c);
        System.out.println("LinkedHashSet: " + noo);
    }

    public static void main(String[] args) {
        CollTest test = new CollTest();
        test.runSet();
    }
}