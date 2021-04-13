package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9324_진짜메시지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <n; ++i){
            boolean flag = false;
            String s = br.readLine();
            int[] alpha = new int[26];
            for(int j = 0 ; j < s.length(); ++j){
                char ch = s.charAt(j);
                ++alpha[ch - 'A'];
                if(alpha[ch - 'A'] == 3){
                    alpha[ch-'A'] = 0;
                    if(j+1 <s.length() && s.charAt(j+1) == ch) ++j;
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) sb.append("FAKE").append("\n");
            else sb.append("OK").append("\n");
        }
        System.out.print(sb);
    }
}
