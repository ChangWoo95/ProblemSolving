package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_11899_괄호끼워넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = getMinPhraseCount(s);
        System.out.println(answer);
    }

    public static int getMinPhraseCount(String s) {
        int ret = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if(stack.peek() != ch) {
                if(ch == '(') {
                    ret += 1;
                    stack.pop();
                    stack.push(ch);
                } else stack.pop();
            }
            else {
                if(ch == ')') {
                    ret += 2;
                    stack.pop();
                } else stack.push(ch);
            }
        }
        if(!stack.isEmpty()) ret += stack.size();
        return ret;
    }

}
