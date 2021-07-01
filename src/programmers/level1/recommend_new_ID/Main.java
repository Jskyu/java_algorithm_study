package programmers.level1.recommend_new_ID;

public class Main {
    public static void main(String[] args) {

        String new_id = "...!@BaT#*.-_.y.abcdefghijklm";
        Solution solution = new Solution();
        System.out.println("answer : "+solution.solution(new_id));
        new_id = "z-+.^.";
        System.out.println("answer : "+solution.solution(new_id));
        new_id = "=.=";
        System.out.println("answer : "+solution.solution(new_id));
        new_id = "123_.def";
        System.out.println("answer : "+solution.solution(new_id));
        new_id = "abcdefghijklmn.p";
        System.out.println("answer : "+solution.solution(new_id));
    }
}
