package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newVal = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int rank = 1, cnt = 0;
        int[] list = new int[100];

        if(n == 0) rank = 1;
        else {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; ++i) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; ++i) {
                if (newVal < list[i]) rank += 1;
                else if (newVal > list[i]) break;
                ++cnt;
            }

            if (cnt == p) rank = -1;
        }
        System.out.println(rank);
    }
}
