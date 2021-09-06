package programmers;

import java.util.Stack;

public class KaKao2020_괄호변환 {

    public static String solution(String p) {
        String answer = convertRightString(p);
        return answer;
    }

    public static boolean isRightString(String s) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }

        if (!st.isEmpty()) return false;
        else return true;
    }

    public static String convertRightString(String p) {
        if (p.length() == 0) return p;
        else {
            int bound = getBound(p);
            String u = p.substring(0, bound);
            String v = p.substring(bound);
            StringBuilder resultBuilder = new StringBuilder();

            if(isRightString(u)) {
                v = convertRightString(v);
                return resultBuilder.append(u).append(v).toString();
            } else {
                v = convertRightString(v);
                resultBuilder.append("(").append(v).append(")");
                resultBuilder.append(reverse(u.substring(1, u.length()-1)));
                return resultBuilder.toString();
            }
        }
    }

    public static String reverse(String u) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0 ; i < u.length(); ++i) {
            char ch = u.charAt(i);
            if(ch == '(')ret.append(')');
            else ret.append('(');
        }
        return ret.toString();
    }

    public static int getBound(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int ret = 0;

        for(int i = 0 ; i < s.length(); ++i) {
            if(s.charAt(i) == '(') ++leftCount;
            else ++rightCount;
            if(leftCount == rightCount) {
                ret = i+1;
                break;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        String s = "()))((()";
        System.out.println(solution(s));
    }


}
