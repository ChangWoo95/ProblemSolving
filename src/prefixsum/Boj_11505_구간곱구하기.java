package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11505_구간곱구하기 {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = (int)Math.ceil(Math.log10(n) / Math.log10(2));
        long[] tree = new long[1 << (h+1)];

        for(int i = 1 ; i <=n; ++i){
            int val = Integer.parseInt(br.readLine());
            update(tree, 1, 1, n, i, val);
        }
        m += k;

        while( m --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                update(tree, 1, 1, n, b, c);
            }else{
                sb.append(multiply(tree, 1, 1, n, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static long multiply(long[] tree, int node, int start, int end, int left, int right){
        if(left > end || right < start) return 1;
        else if(left <= start && end <= right) return tree[node];
        return (multiply(tree, node*2, start, (start+end)/2, left, right)*multiply(tree, node*2 +1, (start+end)/2 +1, end, left, right)) %mod;
    }
    static long update( long[] tree, int node, int start, int end, int index, int val){
        if(index < start || index > end) return tree[node];
        if (start == end) return tree[node] = val;
        return tree[node] = (update(tree, node*2, start, (start+end)/2, index, val) * update(tree, node*2+1, (start+end)/2 + 1, end, index, val)) %mod;
    }
}
