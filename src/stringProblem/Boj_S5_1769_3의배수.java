package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_S5_1769_3의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); //한 줄 입력받기
        int cnt = 0; // 몇번 반복되었는지 확인

        while(s.length() != 1){  // 한자리 숫자가 아닐 때까지
            int answer = 0;
            for(char ch: s.toCharArray()){
                answer += ch - '0';
                //Character.getNumericValue()도 가능!
            }
            s = Integer.toString(answer);
            cnt++;
        }

        if (Integer.parseInt(s) % 3 != 0) {
            System.out.println(cnt);
            System.out.println("NO");
        } else {
            System.out.println(cnt);
            System.out.println("YES");
        }
    }
}
