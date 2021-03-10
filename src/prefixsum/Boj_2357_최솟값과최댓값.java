package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2357_최솟값과최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = (int)Math.ceil((Math.log10(n) / Math.log10(2)));
        int[] arr = new int[n];

        for(int i = 0 ; i < n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] minTree = new int[1 << (h+1)];
        initMin(arr, minTree, 1, 0, n-1);
        int[] maxTree = new int[1 << (h+1)];
        initMax(arr, maxTree, 1, 0, n-1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;

            sb.append(findMin(minTree, 0, n-1, 1, left, right)).append(" ").append(findMax(maxTree, 0, n-1, 1, left, right)).append("\n");
        }
        System.out.print(sb);
    }

    static int initMin(int[] arr, int[] minTree, int node, int start, int end){
        if(start == end) return minTree[node] = arr[start];
        else return minTree[node] = Math.min(initMin(arr, minTree, node*2, start, (start + end)/ 2), initMin(arr, minTree, node*2 + 1, (start+end)/2 + 1, end) );
    }

    static int initMax(int[] arr, int[] maxTree, int node, int start, int end){
        if(start == end) return maxTree[node] = arr[start];
        else return maxTree[node] = Math.max(initMax(arr, maxTree, node*2, start, (start + end)/ 2), initMax(arr, maxTree, node*2 + 1, (start+end)/2 + 1, end) );
    }

    static int findMin(int[] minTree, int start, int end, int node, int left, int right){
        if(right < start || end < left){
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){
            return minTree[node];
        }
        return Math.min(findMin(minTree, start, (start + end)/2, node*2, left, right), findMin(minTree, (start+end)/2 + 1, end , node*2 + 1, left, right) );
    }

    static int findMax(int[] maxTree, int start, int end, int node, int left, int right){
        if(right < start || end < left){
            return Integer.MIN_VALUE;
        }
        if(left <= start && end <= right){
            return maxTree[node];
        }
        return Math.max(findMax(maxTree, start, (start + end)/2, node*2, left, right), findMax(maxTree, (start+end)/2 + 1,end, node*2 + 1, left, right) );
    }

}
