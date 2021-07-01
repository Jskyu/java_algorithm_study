package programmers.level2.멀쩡한_사각형;

class Solution {
    public long solution(int w, int h) {
        long lw = w;
        long lh = h;
        if(lw == lh){
            return (lw*lh) - lh;
        }

        long min = Math.min(lw, lh);
        long max = Math.max(lw, lh);
        long value = 1;

        while (value > 0) {
            value = max % min;
            max = min;
            min = value;
        }

        return lw * lh - (lw + lh - max);
    }
}