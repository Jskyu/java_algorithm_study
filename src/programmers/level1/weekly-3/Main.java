package programmers.level1.weekly-3;

import java.util.*;

/*
개발자가 사용하는 언어와 언어 선호도를 입력하면 그에 맞는 
직업군을 추천해주는 알고리즘을 개발하려고 합니다.

아래 표는 5개 직업군 별로 많이 사용하는 5개 언어에 직업군 언어 점수를 부여한 표입니다.

점수	SI			CONTENTS	HARDWARE	PORTAL		GAME
5	JAVA		JAVASCRIPT	C			JAVA		C++
4	JAVASCRIPT	JAVA		C++			JAVASCRIPT	C#
3	SQL			PYTHON		PYTHON		PYTHON		JAVASCRIPT
2	PYTHON		SQL			JAVA		KOTLIN		C
1	C#			C++			JAVASCRIPT	PHP			JAVA
예를 들면, SQL의 SI 직업군 언어 점수는 3점이지만 CONTENTS 직업군 언어 점수는 2점입니다.
 SQL의 HARDWARE, PORTAL, GAME 직업군 언어 점수는 0점입니다.
 */
public class Main {
	public static void main(String[] args) {
		String[] table = {
				"SI JAVA JAVASCRIPT SQL PYTHON C#",
				"CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA"}
		String[] languages = {"JAVA", "JAVASCRIPT"}
		int[] preference = {7, 5};

		System.out.println("answer = "+solution(table, languages, preference));
	}
	
	private static String solution(String[] table, String[] languages, int[] preference) {
		int[] scores = {5,4,3,2,1};
        Map<String, Integer> map = new HashMap<>();
        
        for(String tab : table){
            String[] jobs = tab.split(" ");
            String job = jobs[0];
            if(!map.containsKey(job)) map.put(job, 0);
            for(int i = 1; i < jobs.length; i++){
                for(int j = 0; j < langs.length; j++){
                    if(langs[j].equals(jobs[i])){
                        map.put(job, map.get(job) + scores[i-1] * prefer[j]);
                    }
                }
            }
        }
        String answer = "";
        int max = 0;
        for(String k : map.keySet()){
            int value = map.get(k);
            if(max < value){
                max = value;
                answer = k;
            } else if(max == value) {
                String[] temp = {answer, k};
                Arrays.sort(temp);
                answer = temp[0];
            }
        }
        
        return answer;
    }
}