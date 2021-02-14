package general;

import java.io.*;
import java.util.*;

public class Boj_1052_물병 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n <= k) System.out.println(0);
        else {
            int idx = 0;
            while(true){
                int ans = 0;
                int tmp = n + idx;
                while(true) {
                    int a = tmp /2;
                    int b = tmp %2;
                    ans += b;
                    tmp = a;
                    if(tmp == 0) break;
                }
                if(ans <= k ) {
                    System.out.println(idx);
                    break;
                }
                else idx++;
            }
        }
    }
}
