package lambda_study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = initData();

//        match(list);
//        System.out.println(findAny(list));

        map(list);
    }

    private static void map(List<Integer> list) {
        List<IntClass> result = list.stream().map(IntClass::new).collect(Collectors.toList());
        result.stream().forEach(r -> System.out.println(r.toString()));
    }

    static class IntClass {
        private int i;
        public IntClass(int i) {
            this.i = i;
        }
        @Override
        public String toString() {
            return "IntClass{" +
                    "i=" + i +
                    '}';
        }
    }

    private static boolean findAny(List<Integer> list) {
        return list.stream().findAny().orElseGet(null).intValue() == list.get(0);
    }

    private static void match(List<Integer> list) {
        List<Integer> resultList = list.stream().filter(i -> i % 3 == 0).collect(Collectors.toList());
        boolean result = list.stream().anyMatch(i -> i % 3 == 0);

        System.out.println("filter Match : " + resultList.stream().allMatch(i -> i % 3 == 0));
        System.out.println("allMatch : " + list.stream().allMatch(i -> i % 3 == 0));
        System.out.println("result = " + result);
    }

    private static List<Integer> initData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 10000) + 1;
            list.add(random);
        }
        return list;
    }
}
