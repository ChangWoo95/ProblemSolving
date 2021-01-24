package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13300_방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] list = new int[2][6];
        int s, y;
        int ans = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list[s][y-1]++;
        }
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if(list[i][j] == 0) continue;
                if(list[i][j] < k) ans++;
                else {
                    if(list[i][j] % k == 0) ans += list[i][j]/k;
                    else ans += list[i][j]/k + 1;
                }
            }
        }
        System.out.println(ans);
    }
}
