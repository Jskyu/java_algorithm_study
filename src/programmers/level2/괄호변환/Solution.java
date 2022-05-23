package programmers.level2.괄호변환;

class Solution {
    public String solution(String p) {
        //1. 입력이 빈 문자열
        StringBuilder sb = new StringBuilder();
        if (p.length() == 0) return "";

        //2. 문자열 분리
        String u = "", v = "";
        int openCount = 0, closeCount = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') openCount++;
            else closeCount++;
            if (openCount == closeCount) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        //3. u가 올바른 문자열인지 검사
        if (!checkAbnormal(u)) //3.1. u가 올바를 경우 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            sb.append(u).append(solution(v));
        else {//4 u가 올바르지 않은 문자열일 경우
            sb.append("(")//4-1. 빈 문자열에 첫 번째 문자로 '('를 붙임.
                    .append(solution(v))//4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임
                    .append(")")//4-3. ')'를 다시 붙임.
                    .append(u.substring(1, u.length() - 1)//4-4. //u의 첫 번째와 마지막 문자를 제거
                    .replaceAll("[(]", "~")
                    .replaceAll("[)]", "(")
                    .replaceAll("~", ")"));//나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        }
        //4-5. 생성된 문자열을 반환합니다.
        return sb.toString();
    }

    private boolean checkAbnormal(String u) {
        int check = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') check++;
            else check--;
            if (check < 0) {
                return true;
            }
        }
        return false;
    }
}