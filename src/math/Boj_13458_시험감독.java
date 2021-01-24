package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13458_시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer Candidates = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long ans = 0;

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int candidate;

        for(int i = 0; i<n; i++){
            candidate = Integer.parseInt(Candidates.nextToken());
            candidate -= B;
            ans++;
            if(candidate > 0 ) {
                if(candidate % C == 0 ) ans += candidate / C;
                else ans += candidate / C + 1;
            }
        }
        System.out.println(ans);
    }
}
