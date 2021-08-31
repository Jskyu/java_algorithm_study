package programmers.level3.hash_4;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        List<PlayInfo> temp = new ArrayList<>();

//        List<PlayInfo> temp = IntStream.range(0, genres.length)
//                .mapToObj(i -> new PlayInfo(i, genres[i], plays[i])).collect(Collectors.toList());

        for (int i = 0; i < genres.length; i++) {
            temp.add(new PlayInfo(i, genres[i], plays[i]));
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<PlayInfo> list = temp.stream()
                .sorted(Comparator.comparing(PlayInfo::getPlayCount).reversed())
                .collect(Collectors.toList());

        map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(Map.Entry::getKey)
                .forEach(str ->
                        list.stream()
                                .filter(t -> t.getGenre().equals(str))
                                .limit(2)
                                .forEach(info -> answer.add(info.getIndex())));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class PlayInfo {
        private int index;
        private String genre;
        private int playCount;

        public PlayInfo(int index, String genre, int playCount) {
            this.index = index;
            this.genre = genre;
            this.playCount = playCount;
        }

        public int getIndex() {
            return index;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlayCount() {
            return playCount;
        }
    }
}