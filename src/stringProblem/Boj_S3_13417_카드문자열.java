package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_S3_13417_카드문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int length = Integer.parseInt(br.readLine());
            String[] list = br.readLine().split(" ");
            String ans = list[0];

            for(int j = 1 ; j< list.length; j++){
                if(ans.charAt(0) < list[j].charAt(0)){
                    ans += list[j];
                } else {
                    ans = list[j] + ans;
                }
            }
            System.out.println(ans);
        }
    }
}
