package programmers.level2.주식가격;

/*for(int j=0;j<prices.length;j++){
    try{
        if(prices[i]<=prices[j+i+1]&&isTrue){
            answer[i]+=1;
            System.out.println("answer["+i+"] = "+answer[i]);
        }

        else isTrue=false;

    }catch(ArrayIndexOutOfBoundsException e){}
}*/

class Solution {
    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];

        for(int i = 0; i < answer.length; i++){
            answer[i] = 0;
        }

        for(int i = 0; i < answer.length; i++){
            int j = i + 1;

            while(true){
                if(i == answer.length - 1)
                    break;
                try{
                    if(! (prices[i] <= prices[j])){
                        answer[i]++;
                        break;
                    }
                    answer[i]++;
                    j++;
                } catch(ArrayIndexOutOfBoundsException e){
                    break;
                }
            }
        }
        return answer;
    }
}
