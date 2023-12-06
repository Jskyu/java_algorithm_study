package programmers.pccp.t_t.n3_아날로그시계;

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startCount = ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) ? 1 : 0;

        return getCount(h2, m2, s2) - getCount(h1, m1, s1) + startCount;
    }

    private int getCount(int h, int m, int s) {
        // 00시 00분 00초 부터 h시 m분 s초 까지 초침이 시, 분침을 지나는 횟수
        // 시침, 분침, 초침이 겹치는 순간은 0시 0분 0초, 12시 0분 0초 2가지 경우뿐
        // 그 외엔 1분이 지날때마다 시,분침을 한번씩 지나간다.
        double degreeH = ((h * 30) + (m * 0.5) + (s * 0.5 / 60)) % 360;
        double degreeM = ((m * 6) + (s * 0.1)) % 360;
        double degreeS = s * 6;

        int count = -1;

        count += (h * 60 + m) * 2; // 분당 2번
        count -= h; // 분침이 59 -> 60으로 갈 땐 00분에서 겹친다.
        if (h >= 12) count -= 2; // 00시에는 시, 분, 초가 하나로 겹치므로 2회 빼줌

        if (degreeS >= degreeH) count++; // 시침 각도보다 초침 각도가 더 넓으면 + 1
        if (degreeS >= degreeM) count++; // 분침 각도보다 초침 각도가 더 넓으면 + 1

        return count;
    }
}