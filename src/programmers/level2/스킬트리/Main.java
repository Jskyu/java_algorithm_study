package programmers.level2.스킬트리;

public class Main {
    public static void main(String[] args){

        String skill = "CBD";
        String[] skill_trees = {"", "CASFGBQWED", "AECB", "BDA"};

        System.out.println("solution(skill, skill_trees) = " + solution(skill, skill_trees));
    }

    private static int solution(String skill, String[] skill_trees){
        int answer = skill_trees.length;
        int beforeIdx = 0, currentIdx = 0;

        for(int i = 0; i < skill_trees.length; i++){
            beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
            System.out.println("i = " + i + ", beforeIdx = " + beforeIdx);

            for(int j = 1; j < skill.length(); j++){
                currentIdx = skill_trees[i].indexOf(skill.charAt(j));

                if((beforeIdx > currentIdx && currentIdx != - 1) || (beforeIdx == - 1 && currentIdx != - 1)){
                    answer--;
                    break;
                }
                beforeIdx = currentIdx;
            }
        }
        return answer;
    }
}
