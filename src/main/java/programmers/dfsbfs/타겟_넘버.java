package programmers.dfsbfs;

public class 타겟_넘버 {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers,0,0,numbers.length,numbers.length,target);

        return answer;
    }

    public void dfs(int[] numbers, int sum, int depth, int n , int r, int target){
        if(depth == r){
            if(sum == target){
                answer++;
            }
            return;
        }

        // +인 경우
        dfs(numbers,sum + numbers[depth],depth +1,n,r,target);

        // -인 경우
        dfs(numbers,sum - numbers[depth],depth + 1,n,r,target);
    }
}
