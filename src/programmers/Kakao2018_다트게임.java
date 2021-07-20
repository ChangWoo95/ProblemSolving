package programmers;
import java.util.*;

public class Kakao2018_다트게임 {
    class Solution {
        public int solution(String dartResult) {
            double answer = 0;
            Stack<Double> st = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < dartResult.length(); ++i) {
                char ch = dartResult.charAt(i);
                if(Character.isAlphabetic(ch)) { // 영역이 걸리는 경우,
                    int expo = convertCharToInt(ch);
                    int num = Integer.parseInt(sb.toString());
                    st.push(Math.pow(num, expo));
                    sb.setLength(0);
                }
                else if(Character.isDigit(ch)){ // 숫자가 걸리는 경우,
                    sb.append(ch);
                }
                else { // 옵션이 걸리는 경우,
                    st = convertOption(st, ch);
                }
            }
            while(!st.isEmpty()) {
                answer += st.pop();
            }


            return (int)answer;
        }

        public Stack<Double> convertOption(Stack<Double> st, char ch) {
            if(ch == '*') {
                int stIdx = 0;
                List<Double> numList = new ArrayList<>();
                while(!st.isEmpty() && stIdx < 2) {
                    numList.add(st.pop() * 2);
                    ++stIdx;
                }
                for(int idx = numList.size()-1; idx >= 0 ; --idx ) {
                    st.push(numList.get(idx));
                }
            }
            else {
                double num = st.pop() * -1;
                st.push(num);
            }
            return st;
        }

        public int convertCharToInt(char ch) {
            if(ch == 'S') return 1;
            else if(ch == 'D') return 2;
            else return 3;
        }
    }

}
