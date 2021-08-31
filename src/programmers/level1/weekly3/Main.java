package programmers.level1.weekly3;

import java.util.*;

/*
	SI			CONTENTS	HARDWARE	PORTAL		GAME
5	JAVA		JAVASCRIPT	C			JAVA		C++
4	JAVASCRIPT	JAVA		C++			JAVASCRIPT	C#
3	SQL			PYTHON		PYTHON		PYTHON		JAVASCRIPT
2	PYTHON		SQL			JAVA		KOTLIN		C
1	C#			C++			JAVASCRIPT	PHP			JAVA
 */
public class Main {
	public static void main(String[] args) {
		String[] table = {
				"SI JAVA JAVASCRIPT SQL PYTHON C#",
				"CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"JAVA", "JAVASCRIPT"};
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
                for(int j = 0; j < languages.length; j++){
                    if(languages[j].equals(jobs[i])){
                        map.put(job, map.get(job) + scores[i-1] * preference[j]);
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