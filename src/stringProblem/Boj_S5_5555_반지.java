package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_S5_5555_반지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String desiredString = br.readLine();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i< n; i++) {
            String tmp = br.readLine();
            String word = tmp + tmp; // 반지처럼 앞과 끝이 연결되어 보이는 상태이므로, 2번 이어붙임
            if (word.contains(desiredString)) { // 문장 내, 원하는 단어가 존재한다면면
               cnt++;
            }
        }
        System.out.println(cnt);
    }
}
