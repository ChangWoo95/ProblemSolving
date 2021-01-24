package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_S4_2847_게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());
        int[] lvList = new int[n];
        int lv = 0;

        for(int i = 0; i < n; i++){
            lvList[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n-1; i > 0; --i) { // 뒤에서부터 탐색해서 현재 값보다 이전 값이 더 크다면 감소시키면서 lv을 증가
            while (lvList[i] <= lvList[i - 1]) {
                lvList[i - 1]--;
                lv++;
            }
        }
        System.out.println(lv);
    }
}
