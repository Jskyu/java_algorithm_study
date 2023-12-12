package programmers.level2.피로도;

class Solution {

    int max = 0;

    public int solution(int k, int[][] dungeons) {
        /*
        [80,20],[50,40],[30,10]
         */
        int answer = -1;
        exhaustive(k, dungeons, 0);
        return max;
    }

    void exhaustive(int k, int[][] dungeons, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (k >= dungeon[0]) {
                int[][] copy = copyAndRemoveArr(dungeons, i);
                exhaustive(k - dungeon[1], copy, count + 1);
            }
        }
    }

    int[][] copyAndRemoveArr(int[][] arr, int removeIdx) {
        if (arr.length <= 1) return new int[][]{};

        int[][] newArr = new int[arr.length - 1][arr[0].length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == removeIdx) continue;
            newArr[j++] = arr[i];
        }

        return newArr;
    }
}
