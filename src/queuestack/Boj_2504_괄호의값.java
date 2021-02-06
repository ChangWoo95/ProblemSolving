package queuestack;

import java.io.*;
import java.util.*;

public class Boj_2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = findCorrect(s);
        System.out.println(ans);
    }
    static int findCorrect(String s){
        Stack<String> st = new Stack<>();
        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch =='(' || ch == '[') st.push(Character.toString(ch));
            else{
                int sum = 0;
                if(st.isEmpty()) return 0;
                while(!st.isEmpty()) {
                    if(!st.peek().equals("(") && !st.peek().equals("[")) sum += Integer.parseInt(st.pop());
                    else break;
                }
                if(st.isEmpty()) return 0;
                if(ch == ')'){
                    if(!st.peek().equals("(")) return 0;
                    st.pop();
                    if(sum != 0) sum*=2;
                    else sum = 2;
                    st.push(Integer.toString(sum));
                }
                else if(ch == ']'){
                    if(!st.peek().equals("[")) return 0;
                    st.pop();
                    if(sum != 0) sum*=3;
                    else sum = 3;
                    st.push(Integer.toString(sum));
                }
            }
        }
        if(st.isEmpty()) return 0;
        else {
            int result = 0;
            while(!st.isEmpty()){
                if(st.peek().equals("(") || st.peek().equals("[")) return 0;
                result += (Integer.parseInt(st.pop()));
            }
            return result;
        }
    }
}
