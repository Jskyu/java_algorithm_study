package programmers.level1.getReportResults;

import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Map<String, String> reportMap = new LinkedHashMap<>();
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        Arrays.stream(id_list).forEachOrdered(s -> {
            map.put(s, 0);
            reportMap.put(s, "");
            resultMap.put(s, 0);
        });

        Arrays.stream(report).distinct().forEach(str -> {
            String[] split = str.split(" ");
            String to = split[0];
            String from = split[1];
            reportMap.put(from, (reportMap.get(from) + " " + to));
            map.put(from, map.get(from) + 1);
        });

        map.forEach((key, v) -> {
            if(v >= k){
                String str = reportMap.get(key);
                String[] reportList = str.trim().split(" ");
                for (String reportName : reportList) {
                    resultMap.put(reportName, resultMap.get(reportName) + 1);
                }
            }
        });
        return resultMap.values().stream().mapToInt(Integer::intValue).toArray();
    }
}
