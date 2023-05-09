package programmers.level3.brians_troubles;

import java.util.*;

public class Solution {
    public String solution(String sentence) {
        /*
        aHbEbLbLbOa cWdOdRdLdDc
        "HaEaLaLaO bWORLDb"
        "SpIpGpOpNpG JqOqA"
        "AxAxAxA oBoBoB"
        */
        final String INVALID = "invalid";
        if(sentence.contains(" ")) return INVALID;

        // 소문자 추출
        List<Character> lowerList = new ArrayList<>();

        for (char c : sentence.toCharArray()) {
            if (isLower(c)) {
                lowerList.add(c);
            }
        }

        List<String> words = new ArrayList<>();
        List<Character> alreadyList = new ArrayList<>();
        int lastIdx = 0;

        for (Character lower : lowerList) {
            if(alreadyList.contains(lower)) continue;
            int count = getCount(lowerList, lower);

            if (count == 2) { //2번 규칙 (1번 포함)
                int startIdx = lowerList.indexOf(lower);
                int endIdx = lowerList.lastIndexOf(lower);

                if (startIdx + 1 != endIdx) { //1, 2번 혼합인 경우
                    List<Character> tempList = lowerList.subList(startIdx + 1, endIdx);
                    Set<Character> temp = new HashSet<>(tempList);
                    if (temp.size() > 2) {
                        return INVALID;
                    } else if (lowerList.lastIndexOf(tempList.get(0)) > endIdx) {
                        return INVALID;
                    }
                    alreadyList.addAll(temp);
                }
                if (sentence.indexOf(lower) > lastIdx) {
                    words.add(sentence.substring(lastIdx, sentence.indexOf(lower)));
                }

                String word = sentence.substring(sentence.indexOf(lower), sentence.lastIndexOf(lower) + 1);

                words.add(word);
                lastIdx = sentence.lastIndexOf(lower) + 1;

            } else { //1번규칙 또는 invalid 일 경우
                int startIdx = sentence.indexOf(lower) - 1;
                int endIdx = sentence.lastIndexOf(lower) + 2;
                if (sentence.length() < endIdx || startIdx < 0) {
                    return INVALID;
                }
                if (lastIdx > startIdx) {
                    return INVALID;
                }
                if (startIdx != lastIdx) {
                    words.add(sentence.substring(lastIdx, startIdx));
                }

                String word = sentence.substring(startIdx, endIdx);
                words.add(word);
                lastIdx = endIdx;
            }

            alreadyList.add(lower);
        }
        if (lastIdx != sentence.length()) words.add(sentence.substring(lastIdx));

        for (String word : words) {
            if (!isValid(word)) {
                return INVALID;
            }
        }

        return words.toString().replace(",", "").replaceAll("[a-z\\[\\]]", "");
    }

    private int getCount(List<Character> lowerList, char lower) {
        return (int) lowerList.stream().filter(c -> c == lower).count();
    }

    private boolean isUpper(char value){
        byte A = (byte) 'A';
        byte Z = (byte) 'Z';

        return A <= value && value <= Z;
    }

    private boolean isLower(char value){
        byte A = (byte) 'a';
        byte Z = (byte) 'z';

        return A <= value && value <= Z;
    }

    private boolean isValid(String word) {
        //규칙 1. 단어 사이사이 소문자가 있어야 한다.
        //규칙 2. 단어 처음과 끝 같은 알파벳이 있어야 한다.
        //규칙 3. 규칙1, 2가 동시에 존재할 수 있다.
        if(word == null || word.length() == 0) return false;
        if(word.length() == 1) return true;
        if (word.replaceAll("[a-z\\[\\]]", "").length() == 0) return false;

        char start = word.charAt(0);
        if (isUpper(start)) { // 규칙2 제외
            return checkRules1(word); //규칙1 검사
        } else { // 규칙2 해당
            char last = word.charAt(word.length() - 1);
            if (start == last) { // 규칙2 검사
                return checkRules1(word.replace(String.valueOf(start), ""));
            } else {
                return false;
            }
        }
    }

    private boolean checkRules1(String word) {
        if (word.length() <= 1) return true;

        char lower = word.charAt(1);
        if(isUpper(lower)) { // 소문자가 아니면 모든 문자가 대문자인지 확인
            return word.replaceAll("[A-Z]", "").length() == 0;
        }

        // 처음단어와 마지막 단어가 소문자인지 확인
        if (isLower(word.charAt(0)) || isLower(word.charAt(word.length() - 1))) {
            return false;
        }

        for (int i = 3; i < word.length(); i+=2) { // 홀수인덱스(짝수번째 인덱스가 lower과 같은지
            if (!(lower == word.charAt(i))) { // 같지않으면 invalid
                return false;
            }
        }
        return true;
    }
}
