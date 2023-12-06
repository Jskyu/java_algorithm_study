package programmers.pccp.t_t.n1_붕대감기;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healTime = bandage[0];
        int healPerSec = bandage[1];
        int healBonus = bandage[2];
        int max = health;

        int time = 0;
        for (int i = 0; i < attacks.length; i++) {
            int healCount = 0;
            int attackTime = attacks[i][0];
            int attackDamage = attacks[i][1];

            for (int j = time; j < attackTime; j++) {
                health += healPerSec;
                if (++healCount >= healTime) {
                    healCount = 0;
                    health += healBonus;
                }
                if (health > max) {
                    health = max;
                }
                time++;
            }
            time++;
            health -= attackDamage;

            if (health <= 0) return -1;
        }

        return health;
    }
}
