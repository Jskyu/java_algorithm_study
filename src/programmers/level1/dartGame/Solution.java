package programmers.level1.dartGame;

class Solution {
    public int solution(String dartResult){
        int answer = 0;
        String[] dart = {"", "", ""};

        String[] split = dartResult.split("");
        int j = 0;
        boolean isCondition = true;
        for(String s : split){
            try{
                Integer.parseInt(s);
                if(!isCondition){
                    isCondition = true;
                    j++;
                }
                dart[j] += s;
            } catch(Exception e){
                dart[j] += s;
                isCondition = false;
            }
        }

        int result = 0;
        int beforeResult;
        boolean isFirstCondition = true;

        for(String s : dart){
            beforeResult = result;
            String[] split1 = s.split("");
            boolean isTen = false;
            if(split1[1].equals("0")){
                result = 10;
                isTen = true;
            } else{
                result = Integer.parseInt(split1[0]);
            }

            int i = 1;
            if(isTen && split1.length >= 3){
                i++;
            }
            switch(split1[i]){
                case "S":
                    i++;
                    break;
                case "D":
                    result = (int) Math.pow(result, 2);
                    i++;
                    break;
                case "T":
                    result = (int) Math.pow(result, 3);
                    i++;
                    break;
                case "*":
                    result += result;
                    if(! isFirstCondition){
                        answer += beforeResult;
                    }
                    break;
                case "#":
                    result = -result;
                    break;
            }
            if(split1.length > i){
                switch(split1[i]){
                    case "*":
                        result += result;
                        if(! isFirstCondition){
                            answer += beforeResult;
                        }
                        break;
                    case "#":
                        result = -result;
                        break;
                }
            }
            answer += result;

            isFirstCondition = false;

            System.out.println("s = "+s+", result = "+result+", before = "+beforeResult+", answer = "+answer);
        }


        return answer;
    }
}