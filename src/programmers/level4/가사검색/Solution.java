package programmers.level4.가사검색;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        long start = System.currentTimeMillis();
        try {
            int[] answer = new int[queries.length];
            Trie frontTrie = new FrontTrie();
            Trie suffixTrie = new BackTrie();
            Map<String, Integer> resultMap = new HashMap<>();

            Arrays.stream(words).forEach(frontTrie::insert);
            Arrays.stream(words).forEach(suffixTrie::insert);

            Arrays.stream(queries)
                    .distinct() //중복제거
                    .forEach(query -> {
                if (query.matches("[?]+")) {// ?로만 구성된 검색키워드
                    resultMap.put(query, (int) Arrays.stream(words).filter(str -> str.length() == query.length()).count());
                } else if (query.startsWith("?")) {// ?로 시작하는 검색 키워드
                    resultMap.put(query, suffixTrie.getCount(query.substring(query.lastIndexOf("?") + 1), query.length()));
                } else {// ?로 끝나는 검색 키워드
                    resultMap.put(query, frontTrie.getCount(query.substring(0, query.indexOf("?")), query.length()));
                }
            });

            for (int i = 0; i < queries.length; i++) {
                answer[i] = resultMap.get(queries[i]);
            }

            return answer;
        } finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("time = " + time + "ms");
        }
    }

    interface Trie {
        void insert(String str);

        int getCount(String word, int len);

        default int getChildNodeCount(Node node, int len){
            int count = 0;
            if (len <= 0) {
                if (node.isEndOfWord()) return 1;
                return 0;
            } else {
                for (Node childNode : node.getChildes().values()) {
                    count += getChildNodeCount(childNode, len - 1);
                }
            }
            return count;
        }
    }

    static class FrontTrie implements Trie {
        Node rootNode = new Node();

        @Override
        public void insert(String str) {
            Node node = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                node = node.getChildes().computeIfAbsent(str.charAt(i), key -> new Node());
            }
            node.setEndOfWord(true);
        }

        @Override
        public int getCount(String word, int len) {//fro??
            Node node = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                node = node.getChildes().getOrDefault(word.charAt(i), null);
                if (node == null) {
                    return 0;
                }
            }

            return getChildNodeCount(node, len - word.length());
        }
    }

    static class BackTrie implements Trie {
        Node rootNode = new Node();

        @Override
        public void insert(String str) {
            Node node = this.rootNode;

            for (int i = str.length() - 1; i >= 0; i--) {
                node = node.getChildes().computeIfAbsent(str.charAt(i), key -> new Node());
            }
            node.setEndOfWord(true);
        }

        @Override
        public int getCount(String word, int len) {//????o
            Node node = this.rootNode;

            for (int i = word.length() - 1; i >= 0; i--) {
                node = node.getChildes().getOrDefault(word.charAt(i), null);
                if (node == null) {
                    return 0;
                }
            }

            return getChildNodeCount(node, len - word.length());
        }
    }

    static class Node {
        private final Map<Character, Node> childes = new HashMap<>();
        private boolean isEndOfWord;

        public Map<Character, Node> getChildes() {
            return childes;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
    }
}