package programmers.level1.basicStringHandling;

public class Main {
    public static void main(String[] args){

        String s = "1234q";
        System.out.println("solution(s) = " + solution(s));
    }

    private static boolean solution(String s){
        if(s.length() == 4 || s.length() == 6){
            for(int i = 0; i < s.length(); i++){
                if(! (0 <= s.charAt(i) && s.charAt(i) <= '9')){
                    return false;
                }
            }
        } else
            return false;


        return true;
    }
}
