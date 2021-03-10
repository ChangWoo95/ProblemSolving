package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2243_사탕상자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int max = 1000000;

        int n = Integer.parseInt(br.readLine());
        int h = (int)Math.ceil(Math.log10(1000000) / Math.log10(2));
        int[] tree = new int[1 << (h+1)];
        while(n --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                int rank = findIndex(tree, 1, b, 1, max);
                update(tree, 1, rank, -1, 1, max);
                sb.append(rank).append("\n");
            }else if(a == 2){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(tree, 1, b, c, 1, max);
            }
        }
        System.out.print(sb);
    }
    static int findIndex(int[] tree, int node, int idx, int start, int end){
        if(start == end) return start;
        if(idx <= tree[node * 2]) return findIndex(tree, node*2, idx, start, (start+ end)/2);
        else return findIndex(tree, node*2 + 1, idx - tree[node*2], (start + end)/ 2 + 1, end);
    }

    static void update(int[] tree, int node, int idx,int diff, int start, int end){
        if(idx < start || idx > end) return;
        tree[node] += diff;
        if(start != end){
            update(tree, node*2, idx, diff, start, (start + end)/ 2);
            update(tree, node* 2 +1, idx, diff, (start+end)/2 + 1, end);
        }
    }
}
