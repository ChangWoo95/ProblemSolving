package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12025_장난꾸러기영훈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        long k = Long.parseLong(br.readLine());
        long bit = k - 1, cnt = 1;

        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) =='6' || s.charAt(i) == '7'){
                if(s.charAt(i) == '6') s.setCharAt(i, '1');
                else if(s.charAt(i) == '7') s.setCharAt(i, '2');
                cnt <<= 1;
            }
        }

        if( cnt < k || k < 0){
            System.out.println(-1);
            System.exit(0);
        }

        for(int i = s.length() - 1; i >=0; --i){
            if(s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) =='6' || s.charAt(i) == '7'){
                if(bit % 2 == 1){
                    if(s.charAt(i) == '1')
                        s.setCharAt(i, '6');
                    else if(s.charAt(i) == '2')
                        s.setCharAt(i, '7');
                }
                bit /= 2;
            }
        }
        System.out.print(s.toString());
    }
}
