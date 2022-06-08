package programmers.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((a,b) -> {
                    if(Long.valueOf(a + b) > Long.valueOf(b+a))
                        return -1;
                    else if(Long.valueOf(a + b) == Long.valueOf(b+a))
                        return 0;
                    else
                        return 1;
                })
                .collect(Collectors.toList());

        for(String s : list){
            answer += s;
        }
        try{
            return String.valueOf(Long.valueOf(answer));
        }catch(Exception e){
            return answer;
        }
    }
}
