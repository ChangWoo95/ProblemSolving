package backtracking;

import java.io.*;
import java.util.*;

public class Boj_1662_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt;
        char ch;
        Stack<Character> st = new Stack<>();
        Stack<Integer> result = new Stack<>();
        String s = br.readLine();

        for(int i =0; i < s.length(); i++){
            ch = s.charAt(i);
            if(ch != ')') st.push(ch);
            else { // ')'가 들어온 경우,
                cnt = 0;
                while(!st.isEmpty() && st.peek() != '('){
                    if(st.peek() == '+') { cnt += result.pop(); st.pop(); }
                    else { st.pop(); cnt++; }
                }
                st.pop();
                if(!st.isEmpty() && Character.isDigit(st.peek())) {
                    cnt *= st.pop() - '0';
                    result.push(cnt);
                    st.push('+');
                }
            }
        }

        cnt = 0;
        while(!st.isEmpty()) {
            if(st.peek() != '+') cnt++;
            st.pop();
        }
        while(!result.isEmpty())
            cnt += result.pop();
        System.out.println(cnt);
    }
}
