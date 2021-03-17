package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3078_좋은친구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer>[] q = new Queue[21];
        for(int i = 0 ; i < 21; ++i){
            q[i] = new LinkedList<>();
        }
        long cnt = 0;
        for(int i = 0 ; i < n; ++i){
            String s = br.readLine();
            int len = s.length();
            while(!q[len].isEmpty() && i - q[len].peek() > k) q[len].poll();
            cnt += q[len].size();
            q[len].add(i);
        }
        System.out.println(cnt);

    }
}
