package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_B2_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.readLine();
        }

        for (String tc : arr) {
            int cnt = 1;
            int answer = 0;
            for(int i = 0; i < tc.length();i++) {
                if(tc.charAt(i) == 'O') {
                    answer += cnt;
                    cnt++;
                }
                else cnt = 1;
            }
            System.out.println(answer);
        }
    }
}
