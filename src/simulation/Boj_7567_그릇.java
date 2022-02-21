package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_7567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(getHeight(s));

    }
    public static int getHeight(String s) {
        Stack<Character> st = new Stack<>();
        int ret = 0;
        for(int i = 0 ; i <s.length(); ++i) {
            char ch = s.charAt(i);
            if(st.isEmpty()) st.push(ch);
            else {
                if(st.peek() == ch) st.push(ch);
                else {
                    ret += 10 + 5 * (st.size() - 1);
                    st.clear();
                    st.push(ch);
                }
            }
        }
        if(!st.isEmpty()) ret += 10 + 5 * (st.size() - 1);
        return ret;
    }
}
