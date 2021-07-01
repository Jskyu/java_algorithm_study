package lambda_study.withStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Driver {
    public static void main(String[] args) {
        // 문자열 List
        List<String> strList = Arrays.asList("1,2,3,4,5,6".split(","));

        // 문자열 List를 Integer List로 변환
        List<Integer> intList = Parser.strToIntList(strList);

        /** 기존 방식 **/
        int sum1 = 0;
        for(Integer integer : intList){
            sum1 += integer;
        }

        /** 람다식 **/
        /* V.1 */
        intList.stream().forEach((Integer i) -> { System.out.println(i); });

        /* V2. */
        intList.forEach(System.out::println);

        int sum2 = intList.stream().mapToInt(Integer::intValue).sum();
        
        System.out.println(sum2); // 21

        /* Stream */
        /** 직렬 처리 방식 **/
        Stream.of("1", "2", "3", "4", "5", "5")
                .filter(x -> {
                    System.out.println("filter : " + x);
                    return !x.equals("5");
                })
                .mapToInt(x -> {
                    System.out.println("map : " + x);
                    return Integer.parseInt(x);
                })
                .forEach(x -> {
                    System.out.println("forEach : " + x);
                });

        /** 병렬 처리 방식 **/
        Stream.of("1", "2", "3", "4", "5", "5")
                .parallel() // 병렬스트림으로 변경
                .filter(x -> {
                    System.out.println("filter : " + x);
                    return !x.equals("5");
                })
                .mapToInt(x -> {
                    System.out.println("map : " + x);
                    return Integer.parseInt(x);
                })
                .forEach(x -> {
                    System.out.println("forEach : " + x);
                });
    }
}

class Parser {
    public static List<Integer> strToIntList(List<String> strList) {
        /** 기존 방식 **/
        /*
        List<Integer> intList = new ArrayList<>();

        for (String value : strList) {
            intList.add(Integer.parseInt(value));
        }

        return intList;
        */

        /** Stream Lambda **/
        return strList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}