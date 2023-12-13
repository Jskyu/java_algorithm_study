package programmers.level2.연속된_부분_수열의_합;
class Solution {
    public long solution(int r1, int r2) {
        return Math.abs(fun(r2) - fun(r1)) + 4;
    }

    // 식
    // f(r2) - f(r1) + 4
    // f = (2x - 1)^2
    // f = 4x^2 + (-4x) + 1
    long fun(int r) {
        return ((2L * r) - 1L) * ((2L * r) - 1L);
    }
}