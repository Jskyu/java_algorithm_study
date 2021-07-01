package programmers.level1.keypadPress;

class Solution {
    public String solution(int[] numbers, String hand){
        StringBuilder answer = new StringBuilder();
        int[] now = {11, 22};

        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                answer.append("L");
                now[0] = number;
            } else if(number == 3 || number == 6 || number == 9){
                answer.append("R");
                now[1] = number;
            } else{
                String who = distance(now, number);
                if(who.equals("l")){
                    answer.append("L");
                    now[0] = number;
                }
                else if(who.equals("r")){
                    answer.append("R");
                    now[1] = number;
                }
                else if(who.equals("e")){
                    if(hand.equals("left")){
                        answer.append("L");
                        now[0] = number;
                    }
                    else if(hand.equals("right")){
                        answer.append("R");
                        now[1] = number;
                    }
                }
            }
        }

        return answer.toString();
    }

    private String distance(int[] now, int number){

        int left = 0;
        int right = 0;

        switch(now[0]){
            case (1):
                switch(number){
                    case (0): left = 4; break;
                    case (8): left = 3; break;
                    case (5): left = 2; break;
                    case (2): left = 1; break;
                }
                break;
            case (4):
                switch(number){
                    case (0): left = 3; break;
                    case (8): case (2): left = 2; break;
                    case (5): left = 1; break;
                }
                break;
            case (7):
                switch(number){
                    case (0): case (5): left = 2; break;
                    case (8): left = 1; break;
                    case (2): left = 3; break;
                }
                break;
            case(11):
                switch(number){
                    case (0): left = 1; break;
                    case (8): left = 2; break;
                    case (5): left = 3; break;
                    case (2): left = 4; break;
                }
                break;
            case(2):
                switch(number){
                    case (0): left = 3; break;
                    case (8): left = 2; break;
                    case (5): left = 1; break;
                    case (2): left = 0; break;
                }
                break;
            case(5):
                switch(number){
                    case (0): left = 2; break;
                    case (8): case (2): left = 1; break;
                    case (5): left = 0; break;
                }
                break;
            case(8):
                switch(number){
                    case (0): case (5): left = 1; break;
                    case (8): left = 0; break;
                    case (2): left = 2; break;
                }
                break;
            case(0):
                switch(number){
                    case (0): left = 0; break;
                    case (8): left = 1; break;
                    case (5): left = 2; break;
                    case (2): left = 3; break;
                }
                break;
        }

        switch(now[1]){
            case (3):
                switch(number){
                    case (0): right = 4; break;
                    case (8): right = 3; break;
                    case (5): right = 2; break;
                    case (2): right = 1; break;
                }
                break;
            case (6):
                switch(number){
                    case (0): right = 3; break;
                    case (8): case (2): right = 2; break;
                    case (5): right = 1; break;
                }
                break;
            case (9):
                switch(number){
                    case (0): case (5): right = 2; break;
                    case (8): right = 1; break;
                    case (2): right = 3; break;
                }
                break;
            case(22):
                switch(number){
                    case (0): right = 1; break;
                    case (8): right = 2; break;
                    case (5): right = 3; break;
                    case (2): right = 4; break;
                }
                break;
            case(2):
                switch(number){
                    case (0): right = 3; break;
                    case (8): right = 2; break;
                    case (5): right = 1; break;
                    case (2): right = 0; break;
                }
                break;
            case(5):
                switch(number){
                    case (0): right = 2; break;
                    case (8): case (2): right = 1; break;
                    case (5): right = 0; break;
                }
                break;
            case(8):
                switch(number){
                    case (0): case (5): right = 1; break;
                    case (8): right = 0; break;
                    case (2): right = 2; break;
                }
                break;
            case(0):
                switch(number){
                    case (0): right = 0; break;
                    case (8): right = 1; break;
                    case (5): right = 2; break;
                    case (2): right = 3; break;
                }
                break;
        }

        if(left == right) {
            return "e";
        }
        return left > right ? "r" : "l";
    }

}
