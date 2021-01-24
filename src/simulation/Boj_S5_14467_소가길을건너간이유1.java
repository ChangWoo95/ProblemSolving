package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_S5_14467_소가길을건너간이유1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] movingRoad = new int[n];
        Arrays.fill(movingRoad, -1);
        int ans = 0;

        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int move = Integer.parseInt(st.nextToken());
            if(movingRoad[idx] != -1 && movingRoad[idx] != move) ans++;
            movingRoad[idx] = move;
        }
        System.out.println(ans);
    }
}