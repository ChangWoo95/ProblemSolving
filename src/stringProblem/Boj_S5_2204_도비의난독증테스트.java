package stringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Boj_S5_2204_도비의난독증테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break; // 들어온 n이 0일 경우, 탈출

            String[] word = new String[n]; // n크기의 string배열 선언
            Map<String, String> org = new HashMap<String, String>(); // 원본 문자열과 소문자화한 문자열을 위한 Map

            for (int i = 0; i< n ; i++){
                String s = br.readLine();
                word[i] = s.toLowerCase();
                org.put(word[i], s);
            }
            Arrays.sort(word);
            System.out.println(org.get(word[0]));
        }

    }

}
