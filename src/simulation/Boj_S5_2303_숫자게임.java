package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_S5_2303_숫자게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cardList = new int[n][5];
        int idx = -1;
        int answer = 0;
        for(int i = 0; i< n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cardList[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0 ;i < n; i++){
            int sum = (cardList[i][4] + cardList[i][3] + cardList[i][2])%10;
            answer = Math.max(answer, sum);
            idx = Math.max(idx, i);
        }
        System.out.println(idx);
    }

}
