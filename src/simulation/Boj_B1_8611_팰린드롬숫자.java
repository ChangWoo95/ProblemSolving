package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Boj_B1_8611_팰린드롬숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] answer = new String[11];
        Arrays.fill(answer, "");
        int fail = 0;

        for(int i = 2;i < 11; i++) {
            BigInteger tmp = new BigInteger(n);
            String ans = "";

            while(tmp != BigInteger.ZERO) {
                ans = tmp.remainder(BigInteger.valueOf(i)) + ans;
                tmp = tmp.divide(BigInteger.valueOf(i));
            }
            if(isPalindrome(ans)){
                answer[i] = ans;
            } else {
                fail++;
            }
        }
        if(fail == 9) {
            System.out.println("NIE");
        } else {
            for (int i = 2; i < 11; i++) {
                if(!answer[i].equals("")) System.out.printf("%d %s\n",i, answer[i]);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() -1 -i)) return false;
        }
        return true;
    }
}
