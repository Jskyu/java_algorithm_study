package backjoon.N1002;

import java.util.Scanner;
//https://www.acmicpc.net/problem/1002
/**
 터렛
 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 2 초	128 MB	158000	33325	26538	21.796%
 문제
 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다.
 다음은 조규현과 백승환의 사진이다.



 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

 입력
 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고,
 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

 -10,000 <= x1, y1, x2, y2 <= 10,000
 0 <= r1, r2 <= 10,000
 출력
 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

 예제 입력
 3
 0 0 13 40 0 37
 0 0 3 0 7 4
 1 1 1 1 1 5
 예제 출력
 2
 1
 0
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        int[] results = new int[times];
        //x1, y1, r1
        int[] A = new int[3];
        //x2, y2, r2
        int[] B = new int[3];
        for (int j = 0; j < times; j++) {
            for (int i = 0; i < 3; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                B[i] = sc.nextInt();
            }
            double abLen = Math.sqrt(Math.pow(Math.abs(A[0] - B[0]), 2) + Math.pow(Math.abs(A[1] - B[1]), 2));
            int rLen = A[2] + B[2];
            int rSub = Math.abs(A[2] - B[2]);

            if(abLen == 0 && A[2] == B[2]) results[j] = -1;    //두 원이 완전히 일치하는 경우
            else if(abLen < rLen && (rSub < abLen)) results[j] = 2;    //두 원의 교점이 2개일 경우
            else if(abLen == rLen || abLen == rSub) results[j] = 1;    //두 원의 교점이 1개일 경우
            else results[j] = 0;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }
}
