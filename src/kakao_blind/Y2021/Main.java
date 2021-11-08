package kakao_blind.Y2021;

import kakao_blind.Y2021.no1_newID.NewID;
import kakao_blind.Y2021.no2_menuRenewal.MenuRenewal;

public class Main {
    public static void main(String[] args) {
        NewID q1 = new NewID();
        String newIdStr = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("newId answer : " + q1.newId(newIdStr).equals("bat.y.abcdefghi"));

        MenuRenewal q2 = new MenuRenewal();
        boolean isQ2 = true;
        String[] q2Orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] q2Course = {2, 3, 4};
        String[] q2Answer = {"AC", "ACDE", "BCFG", "CDE"};
        String[] q2Result = q2.solution(q2Orders, q2Course);
        if(q2Answer.length == q2Result.length){
            for (int i = 0; i < q2Answer.length; i++) {
                if(!q2Answer[i].equals(q2Result[i])) {
                    isQ2 = false;
                    break;
                }
            }
        }

        System.out.println("Q2 answer : " + isQ2);
    }
}