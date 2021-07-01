package programmers.level1.recommend_new_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
 * 다음은 카카오 아이디의 규칙입니다.
 *
 * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
 * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
 * 네오는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가
 * 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
 * 신규 유저가 입력한 아이디가 new_id 라고 한다면,
 *
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        //1~2단계
        new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").trim();

        List<Character> list = new ArrayList<>();
        for (char c : new_id.toCharArray()) {
            list.add(c);
        }

        char temp = 0;
        int i = 0;
        //3단계
        while (i < list.size()) {
            if (list.get(i).equals('.') && temp == '.') {
                list.remove(i);
            } else {
                temp = list.get(i);
                i++;
            }
        }

        //4단계
        if(list.size() != 0){
            if (list.get(0) == '.') list.remove(0);
            if (list.size() != 0 && list.get(list.size() - 1) == '.') list.remove(list.size() - 1);
        }
        //5단계
        if(list.size() == 0){
            list.add('a');
        }

        //6단계
        if(list.size() >= 16){
            for (int j = 15; j < list.size(); j = 15) {
                list.remove(15);
            }
            if (list.get(list.size() - 1) == '.') {
                list.remove(list.size() - 1);
            }
        }

        //7단계
        if(list.size() <= 2){
            char lastIndex = list.get(list.size() - 1);
            for (int j = 0; j < 4-list.size(); j++) {
                list.add(lastIndex);
            }
        }

        for (Character character : list) {
            answer.append(character);
        }

        return answer.toString();
    }
}
