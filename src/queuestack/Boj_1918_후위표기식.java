package queuestack;

import java.io.*;
import java.util.*;

public class Boj_1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> op = new Stack<>();
        String s = br.readLine(); char ch;

        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) sb.append(ch);
            else {
                switch (ch) {
                    case '(':
                        op.push(ch);
                        break;
                    case '*':
                    case '/':
                        while (!op.empty() && (op.peek() == '*' || op.peek() == '/')) sb.append(op.pop());
                        op.push(ch);
                        break;
                    case '+':
                    case '-':
                        while (!op.empty() && op.peek() != '(') sb.append(op.pop());
                        op.push(ch);
                        break;
                    case ')':
                        while (!op.empty() && op.peek() != '(') sb.append(op.pop());
                        op.pop();
                        break;
                }
            }
        }
        while(!op.isEmpty()) sb.append(op.pop());
        System.out.print(sb);
    }
}
