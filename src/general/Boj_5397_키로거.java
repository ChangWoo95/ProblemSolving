package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Boj_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t< T; ++t){
            Stack<Character> st1 = new Stack<>();
            Stack<Character> st2 = new Stack<>();
            String s = br.readLine();

            for(int i = 0 ; i < s.length(); ++i){
                char ch = s.charAt(i);
                if(ch == '<'){
                    if(!st2.isEmpty()) st1.push(st2.pop());
                } else if(ch == '>') {
                    if(!st1.isEmpty()) st2.push(st1.pop());
                } else if(ch == '-'){
                    if(!st2.isEmpty()) st2.pop();
                } else {
                    st2.push(ch);
                }
            }
            while(!st1.isEmpty()) st2.push(st1.pop());
            StringBuilder tmp = new StringBuilder();
            while(!st2.isEmpty()){
                tmp.append(st2.pop());
            }
            sb.append(tmp.reverse());
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
