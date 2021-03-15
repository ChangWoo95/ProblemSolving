package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/** 
* @since 2021-03-15
* @author ChangWoo95
* @see 두 포인터의 조건 설정 및 나머지 하나를 무엇으로 찾아낼 것인가
* @time
* @mem
* @caution 정렬, 타입 범위
*/
public class Boj_2473_세용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; ++i) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        long initSum = Long.MAX_VALUE;
        int lowAns = 0, highAns = 0, midAns = 0;

        for (int i = 0; i < n; ++i) {
            int left = i+1, right = n - 1;

            while (left < right) {
                long sum = (long)list[left] + list[right] + list[i];
                if (Math.abs(sum) < initSum) {
                    initSum = Math.abs(sum);
                    lowAns = list[i];
                    highAns = list[right];
                    midAns = list[left];
                }

                if (sum < 0) ++left;
                else --right;
            }
        }
        System.out.println(lowAns + " " + midAns + " " + highAns);
    }

}
