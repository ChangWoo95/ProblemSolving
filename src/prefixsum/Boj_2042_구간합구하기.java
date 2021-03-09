package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2042_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = (int)Math.ceil((Math.log10((double)n) /Math.log10((double)2)));
        long[] arr = new long[n];

        for(int i = 0; i <n; ++i){
            arr[i] = Long.parseLong(br.readLine());
        }
        m+= k;
        long[] tree = new long[1 << (h + 1)];
        init(arr, tree, 1, 0, n-1);
        while(m -- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[b];
                arr[b] = c;
                update(tree, 1, 0, n-1, b, diff);
            } else if(a == 2){
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(sum(tree, 1, 0,n-1, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static long init(long[] arr, long[] tree, int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        else return tree[node] = init(arr, tree, node*2, start, (start+end)/2) + init(arr ,tree, node*2 +1, (start+end)/2 + 1, end);
    }
    static long sum(long[] tree, int node, int start, int end, int left, int right){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        return sum(tree, node*2, start, (start+end)/2, left, right) + sum(tree, node*2 + 1, (start+end)/2 + 1, end, left, right);
    }
    static void update(long[] tree, int node, int start, int end, int index, long diff){
        if(index < start || index > end) return ;
        tree[node] += diff;
        if(start != end){
            update(tree, node*2, start, (start+end)/2, index, diff);
            update(tree, node*2 + 1, (start + end)/2 +1,end,index, diff);
        }
    }
}
