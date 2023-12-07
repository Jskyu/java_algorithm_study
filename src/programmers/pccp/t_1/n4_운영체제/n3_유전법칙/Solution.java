package programmers.pccp.t_1.n4_운영체제.n3_유전법칙;

import java.util.*;

class Solution {

    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        Queue<int[]> list = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        Queue<int[]> wait = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        for (int[] arr : program) {
            list.offer(arr);
        }

        while (!list.isEmpty() || !wait.isEmpty()) {
            while (!list.isEmpty()) {
                if (list.peek()[1] <= answer[0]) {
                    wait.offer(list.poll());
                } else break;
            }

            if (wait.isEmpty()) { // 대기중인 시스템이 없다면 다음 프로그램 실행시간까지 넘어감
                int[] next = list.peek();
                answer[0] += (next[1] - answer[0]);
                continue;
            }
            int[] now = wait.poll();

            int runningTime = now[2];
            answer[now[0]] += (answer[0] - now[1]);
            answer[0] += runningTime;
        }

        return answer;
    }

    public long[] solution2(int[][] program) {
        long[] answer = new long[11];
        List<Program> list = new ArrayList<>();
        List<Program> wait = new ArrayList<>();

        for (int i = 0; i < program.length; i++) {
            list.add(new Program(i+1, program[i]));
        }
        list.sort((p1, p2) -> p1.compareTo(p2));

        while (!list.isEmpty() || !wait.isEmpty()) {
            set(list, wait, answer[0]);

            if (wait.isEmpty()) { // 대기중인 시스템이 없다면 다음 프로그램 실행시간까지 넘어감
                Program prog = list.get(0);
                answer[0] += prog.callTime - answer[0];
                continue;
            }
            Program now = wait.remove(0);

            answer[now.score] += answer[0] - now.callTime;
            answer[0] += now.time;
        }

        return answer;
    }

    // 우선순위큐 처럼 해보려 했으나.. PriorityQueue 에서 데이터를 입력하면 shift 연산을 하는데 너무 어렵다.
    private void set(List<Program> list, List<Program> wait, long time) {
        List<Program> remove = new ArrayList<>();
        for (Program program : list) {
            if (program.callTime <= time) {
                int i = 0;
                for (i = 0; i < wait.size(); i++) {
                    if (wait.get(i).score > program.score) {
                        break;
                    }
                }
                remove.add(program);
                wait.add(i, program);
            }
            else {
                break;
            }
        }
        if (!remove.isEmpty()) {
            list.removeAll(remove);
        }
    }

    static class Program implements Comparable<Program> {
        int number;

        int score;
        long callTime;
        int time;

        public Program(int number, int[] program) {
            this.number = number;
            this.score = program[0];
            this.callTime = program[1];
            this.time = program[2];
        }

        @Override
        public int compareTo(Program p) {
            if (this.callTime == p.callTime) {
                return Integer.compare(this.score, p.score);
            }
            return Long.compare(this.callTime, p.callTime);
        }
    }
}