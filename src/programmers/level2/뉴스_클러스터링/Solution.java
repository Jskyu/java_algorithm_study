package programmers.level2.뉴스_클러스터링;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        long start = System.currentTimeMillis();
        try {
            str1 = str1.toLowerCase().replaceAll("[^a-z]", "~");
            str2 = str2.toLowerCase().replaceAll("[^a-z]", "~");

            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();

            for (int i = 0; i < str1.length() - 1; i++) {
                String str = str1.substring(i, i + 2);
                if (!str.contains("~")) list1.add(str);
            }
            for (int i = 0; i < str2.length() - 1; i++) {
                String str = str2.substring(i, i + 2);
                if (!str.contains("~")) list2.add(str);
            }

            //교집합
            List<String> interList = new ArrayList<>();
            List<String> unionList = new ArrayList<>(list2);

            for (String str : list1) {
                if (unionList.contains(str)) {
                    unionList.remove(unionList.lastIndexOf(str));
                    interList.add(str);
                }
            }
            //합집합
            unionList.addAll(list1);

            double inter = interList.size();
            double union = unionList.size();

            return inter + union == 0 ? 65536 : (int) ((inter / union) * 65536);
        } finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("time = " + time + "ms");
        }
    }
}