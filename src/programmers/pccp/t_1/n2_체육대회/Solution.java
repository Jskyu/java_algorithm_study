package programmers.pccp.t_1.n2_체육대회;

class Solution {

    int max = 0;
    int abilityCount = 0;
    public int solution(int[][] ability) {
        abilityCount = ability[0].length;
        dfs(ability, 0, 0);

        return max;
    }

    private void dfs(int[][] ability, int sum, int count) {
        if (count == abilityCount) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            int[][] abil = removeAndCopyArr(ability, i);
            dfs(abil, sum + ability[i][count], count + 1);
        }
    }

    private int[][] removeAndCopyArr(int[][] arr, int index) {
        if (arr.length - 1 <= 0) return null;

        int[][] newArr = new int[arr.length - 1][arr[0].length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }

        return newArr;
    }
}