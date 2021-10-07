package programmers.level2.open_chattingroom;

import java.util.*;

public class Solution {
    Map<String, String> userMap = new HashMap<>(); //key : id, value : nick

    public String[] solution(String[] record) {
        Arrays.stream(record).filter(str -> !str.split(" ")[0].equals("Leave")).forEach(str -> {
            String[] split = str.split(" ");
            userMap.put(split[1], split[2]);
        });

        return Arrays.stream(record).filter(str -> !str.split(" ")[0].equals("Change")).map(this::createMsg).toArray(String[]::new);
    }

    public String createMsg(String str) {
        String stats = str.split(" ")[0];
        String id = str.split(" ")[1];
        switch (stats) {
            case "Enter":
                return userMap.get(id) + "님이 들어왔습니다.";
            case "Leave":
                return userMap.get(id) + "님이 나갔습니다.";
        }
        return "ERROR";
    }
}