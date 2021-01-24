package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_S5_4096_팰린드로미터 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringBuilder s = new StringBuilder(br.readLine());
            int num = Integer.parseInt(s.toString());
            if (num == 0) break;
            else {
                int cnt = 0;
                while(true) {
                    if(isPalindrome(s.toString())) break;

                    boolean al = true;
                    int i = 0;
                    int en = s.length() - 1;
                    while(al){
                        al = false;
                        if(s.charAt(en - i) + 1 > '9') {
                            s.setCharAt(en - i,'0');
                            al = true;
                        } else {
                            s.setCharAt(en - i, (char)(s.charAt(en-i) + 1) );
                        }
                        i++;
                    }
                    cnt++;
                }
                System.out.println(cnt);
            }
        }
    }
    public static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
