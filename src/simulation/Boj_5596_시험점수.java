package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5596_시험점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minkukTotalSum = 0;
        int manseTotalSum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            minkukTotalSum += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            manseTotalSum += Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.max(minkukTotalSum, manseTotalSum));
    }
}
