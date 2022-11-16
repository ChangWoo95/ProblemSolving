package day20221116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * fileName       : Boj25497_기술연계마스터임스
 * author         : changwoo95
 * date           : 2022-11-16
 * description    : 특정 연계되는 스킬에 대한 validation 처리를 제대로 할 수 있는가. 이전 선택에 의해 경우의수가 생기는 가지형(백트래킹)이 아닌
 *                  단순히 이전 값과의 연계를 생각해야 하기에 stack을 고려한 풀이를 생각할 줄 알아야 함
 **/
public class Boj25497_기술연계마스터임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Character> combo1 = new Stack<>();
        Stack<Character> combo2 = new Stack<>();

        int answer = 0;

        for(int i = 0 ; i < n; ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
               ++answer;
            } else {
                if (ch == 'S') {
                    combo1.push(ch);
                } else if (ch == 'L') {
                    combo2.push(ch);
                } else if (ch == 'K') {
                    if (!combo1.isEmpty()) {
                        combo1.pop();
                        ++answer;
                    } else {
                        break;
                    }
                } else if (ch == 'R') {
                    if (!combo2.isEmpty()) {
                        combo2.pop();
                        ++answer;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
