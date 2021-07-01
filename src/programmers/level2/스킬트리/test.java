package programmers.level2.스킬트리;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args){

        String skill = "CBD";
        String[] skill_trees = {"", "CBADF", "AECB", "BDA"};

        System.out.println("solution(skill, skill_trees) = " + solution(skill, skill_trees));
    }

    private static int solution(String skill, String[] skill_trees){
        int answer = 0;
        List<String> strArr = new ArrayList<>();

        for(int i = 0; i < skill_trees.length; i++){
            String str = "";
            for(int j = 0; j < skill_trees[i].length(); j++){

                for(int k = 0; k < skill.length(); k++){
                    if(skill_trees[i].charAt(j) == skill.charAt(k)){
                        str += skill.charAt(k);
                    }
                }
            }
            System.out.println("str = " + str);
            if(str.length() >= 1)
                strArr.add(str);
            else if(str.length() < 1)
                answer++;

        }

        for(int i = 0; i < strArr.size(); i++){
            if(checkSkillTree(strArr.get(i), skill)){
                answer++;
            }
        }


        return answer;
    }

    private static boolean checkSkillTree(String str, String skill){
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != skill.charAt(j)){
                return false;
            }
            j++;
        }
        return true;
    }
}
