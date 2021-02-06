package queuestack;

import java.io.*;
import java.util.*;
/**
* @since 2021-02-04
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/2493
* @time 688ms
* @mem 71672KB
* @caution  연산속도때문에 시간초과날까봐 스택이 아닌 다른 방식으로 접근했는데 stack으로 해도 될 것 같다...
*/
public class Boj_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] value = new int[500001];
        int[] idx = new int[500001];
        int prev = 0;

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (prev > 0) { // 현재 들어온 value보다 큰 prev값 찾기
                if (value[prev] >= height) {
                    sb.append(idx[prev]).append(" ");
                    break;
                } else prev--;
            }
            if (prev == 0) sb.append(0).append(" "); // 다 훑어도 input값보다 크거나 같은 경우가 없을 경우,
            idx[++prev] = i;
            value[prev] = height;
        }
        System.out.print(sb);
    }
}
        /*    처음 풀던 코드 ---> 문제점: 이전값들 중 가장 큰수 하나만 담는 방식이어서 들어온 값이 이전의 값들 중, 같거나 큰 경우를 잡아주지 못함
        * ------> 해결 : 이전값을 담아주는 배열을 선언하여 해결함 */
       /* int prev = Integer.parseInt(st.nextToken());
        int prevmax = prev;
        int idx = 1;
        sb.append(0).append(" ");
        int next = 0;

        for(int i = 2; i <= n; i++){
            next = Integer.parseInt(st.nextToken());
            if(prev >= next) sb.append(i-1).append(" ");
            else {
                if(prevmax > next) sb.append(idx).append(" ");
                else if(prevmax == next) sb.append(i).append(" ");
                else {
                    sb.append(0).append(" ");
                    prevmax = next;
                    idx = i;
                }
            }
            prev = next;
        }*/
