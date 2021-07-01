package programmers.level1.secretMap;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = new int[]{46, 33, 33, 22, 31, 50};
        int[] arr2 = new int[]{27, 56, 19, 14, 14, 10};
        String[] var7;
        int var6 = (var7 = solution(n, arr1, arr2)).length;

        for(int var5 = 0; var5 < var6; ++var5) {
            String s = var7[var5];
            System.out.println(s);
        }

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < answer.length; ++i) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

            for(int j = answer[i].length(); j < n; ++j) {
                answer[i] = "0" + answer[i];
            }

            answer[i] = answer[i].replace('0', ' ').replace('1', '#');
        }

        return answer;
    }
}
