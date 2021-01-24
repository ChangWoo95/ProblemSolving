package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_S3_18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] land = new int[n][m];
        int maxH = Integer.MIN_VALUE;
        int minH = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <m; j++){
                land[i][j] = Integer.parseInt(st.nextToken());
                if(land[i][j] > maxH) land[i][j] = maxH;
                if(land[i][j] < minH) land[i][j] = minH;
            }
        }

        for(int i = maxH; i >= minH; i--){

        }

    }
}
