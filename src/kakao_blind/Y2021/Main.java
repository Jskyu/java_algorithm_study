package kakao_blind.Y2021;

import kakao_blind.Y2021.no1_newID.NewID;

public class Main {
    public static void main(String[] args) {
        NewID newId = new NewID();
        String newIdStr = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("newId answer : " + newId.newId(newIdStr).equals("bat.y.abcdefghi"));

    }
}