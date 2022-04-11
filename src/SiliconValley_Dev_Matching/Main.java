package SiliconValley_Dev_Matching;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int rows = 4;
        int columns = 3;
        int[][] connections = {{1,1,2,1},{1,2,1,3},{1,3,2,3},{2,2,2,3},{2,2,3,2},{2,3,3,3},{3,2,3,3},{3,2,4,2},{4,1,4,2}};
        int[][] queries = {{2, 2, 3, 1}, {1, 2, 4, 2}};

        int[] result1 = s.q1(rows, columns, connections, queries);
        System.out.print("result :");
        for (int i : result1) {
            System.out.print(" " + i);
        }

//        String[] names = {"azad", "andy", "louis", "will", "edward"};
//        int[][] homes = {{3,4},{-1,5},{-4,4},{3,4},{-5,0}};
//
//        double[] grades = {4.19, 3.77, 4.41, 3.65, 3.58};
//
//        int[] result2 = s.q2(names, homes, grades);
//
//        System.out.print("result :");
//        for (int i : result2) {
//            System.out.print(" " + i);
//        }
    }
}
