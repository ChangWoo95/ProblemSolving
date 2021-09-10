package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3541_상근타워 {
    public static int n, m;
    public static int[][] elevators;
    public static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 0; i <m; ++i) {
            lowerBound(i);
        }
        System.out.println(answer);
    }

    public static void lowerBound(int idx) {
        int upBtn = elevators[idx][0];
        int downBtn = elevators[idx][1];

        int low = 1;
        int high = n+1;

        while(low < high) {
            int mid = (low + high) / 2;
            long plusFloor = (long) mid * upBtn;
            long minusFloor = (long) (n - mid) * downBtn;
            if(plusFloor + minusFloor > 0) {
                high = mid;
                answer = Math.min(answer, (plusFloor + minusFloor));
            }
            else low = mid + 1;
        }

        return;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        elevators = new int[m][2];
        for(int i = 0 ; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            elevators[i][0] = Integer.parseInt(st.nextToken());
            elevators[i][1] = -1 * Integer.parseInt(st.nextToken());
        }

        return;
    }
}
