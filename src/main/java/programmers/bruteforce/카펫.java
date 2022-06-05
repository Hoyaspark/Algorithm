package programmers.bruteforce;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1;i<=yellow;i++){
            int div = yellow/i;
            if(yellow % i == 0 && div >= i){
                int sum = (i * 2) + (div * 2) + 4;
                if(brown == sum){
                    answer[0] = div+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }
        return answer;
    }
}
