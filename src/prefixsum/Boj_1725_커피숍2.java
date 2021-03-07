package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1725_커피숍2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int h = (int)Math.ceil( Math.log10(n) / Math.log10(2) );
        long[] list = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i =0; i < n; ++i){
            list[i] = Long.parseLong(st.nextToken());
        }
        long[] tree = new long[1 << (h + 1)];
        init(list, tree, 1, 0, n-1);
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            if(a > b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            sb.append(sum(tree, 1, 0, n-1, a, b)).append("\n");
            long diff = (long)d - list[c];
            list[c] = d;
            update(tree, 1, 0, n-1, c, diff);
        }
        System.out.print(sb);
    }
    static long init(long[] list, long[] tree, int node, int start, int end){
        if(start == end) return tree[node] = list[start];
        else return tree[node] = init(list, tree, node*2, start, (start + end)/2) + init(list, tree, node*2+1, (start+end)/2 + 1,end);
    }

    static long sum(long[] tree, int node, int start, int end, int left, int right){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        return sum(tree, node*2, start, (start+end)/2, left, right) + sum(tree, node*2 + 1, (start + end)/2 + 1, end, left, right);
    }
    static void update(long[] tree, int node, int start, int end, int index, long diff){
        if(index < start || index > end) return;
        tree[node] += diff;
        if(start != end){
            update(tree, node*2, start, (start+end)/2, index, diff);
            update(tree, node*2 + 1, (start + end)/2 + 1, end, index, diff);
        }
    }
}
