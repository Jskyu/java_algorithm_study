package generic.list;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        NumberList<Integer> list = new NumberList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("list = " + list);

        int i = list.get(0);
        boolean b1 = i == 1;
        System.out.println("b1 = " + b1);

        int size = list.size();
        System.out.println("size = " + size);

        boolean contains = list.contains(1);
        System.out.println("contains = " + contains);

        List<Integer> collect = list.stream().map(a -> 3).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        NumberList<Integer> toNumberList = NumberList.toNumberList(collect);
        System.out.println("toNumberList = " + toNumberList);

        NumberList<Integer> asList = NumberList.asList(1, 2, 3, 4, 5);
        System.out.println("asList = " + asList);

        NumberList<Double> dAsList = NumberList.asList(1.1, 1.2, 1.3, 1.4);
        System.out.println("dAsList = " + dAsList);

        NumberList<Float> fAsList = NumberList.asList(1.1f, 1.2f, 2f, 1.3f);
        System.out.println("fAsList = " + fAsList);

        //컴파일 에러 !!
        //NumberList<String> stringNumberList = NumberList.asList("a", "b", "c");
    }
}
