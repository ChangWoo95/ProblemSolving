package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2566_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[9][9];
        int max = Integer.MIN_VALUE;
        int r = 0, c = 0;

        for (int i = 0; i < 9; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max <= map[i][j]){
                    max = map[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        sb.append(max).append("\n");
        sb.append(r+1).append(" ").append(c+1);
        System.out.print(sb);
    }
}
