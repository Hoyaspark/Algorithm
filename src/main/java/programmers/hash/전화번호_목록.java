package programmers.hash;

import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return answer;
    }
}
