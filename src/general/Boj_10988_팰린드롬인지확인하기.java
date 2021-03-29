package general;

import java.io.*;

public class Boj_10988_팰린드롬인지확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if(isPalindrome(s)) System.out.println(1);
        else System.out.println(0);;

    }
    static boolean isPalindrome(String s){
        for(int i = 0 ; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() -1 -i)) return false;
        }
        return true;
    }
}
