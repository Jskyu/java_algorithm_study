package kakao_blind.Y2021;

import kakao_blind.Y2021.no1_newID.NewID;
import kakao_blind.Y2021.no2_menuRenewal.MenuRenewal;
import kakao_blind.Y2021.no3_searchRank.SearchRank;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /* //Q1
        NewID q1 = new NewID();
        String newIdStr = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("newId answer : " + q1.newId(newIdStr).equals("bat.y.abcdefghi"));
        */

        /* //Q2
        MenuRenewal q2 = new MenuRenewal();
        boolean isQ2 = true;
        String[] q2Orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] q2Course = {2, 3, 4};
        String[] q2Answer = {"AC", "ACDE", "BCFG", "CDE"};
        String[] q2Result = q2.solution(q2Orders, q2Course);
        if (q2Answer.length == q2Result.length) {
            for (int i = 0; i < q2Answer.length; i++) {
                if (!q2Answer[i].equals(q2Result[i])) {
                    isQ2 = false;
                    break;
                }
            }
        }

        System.out.println("Q2 answer : " + isQ2);
        */

        SearchRank q3 = new SearchRank();

        String[] q3Info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] q3Query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] q3Result = q3.solution(q3Info, q3Query);
        System.out.print("Q3. Answer : ");
        Arrays.stream(q3Result).forEach(i -> System.out.print(i + " "));

    }
}