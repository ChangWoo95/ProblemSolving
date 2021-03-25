package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list= new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i){
            list[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(Integer.MIN_VALUE);
        int[] index = new int[n];

        for(int i = 0; i<n; ++i){
            if(lis.get(lis.size()-1) < list[i]){
                lis.add(list[i]);
                index[i] = lis.size() - 1;
            } else{
                int left = 1, right = lis.size() - 1;
                while(left < right){ // lower bound
                    int mid = (left + right) / 2;
                    if(lis.get(mid) >= list[i]) right = mid;
                    else left = mid+1;
                }
                lis.set(right, list[i]);
                index[i] = right;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()-1).append("\n");
        Stack<Integer> ss = new Stack<>();

        int idx = lis.size()-1;
        for(int i = n-1; i>=0; --i){
            if(index[i] == idx){
                --idx;
                ss.push(list[i]);
            }
        }
        while(!ss.isEmpty()){
            sb.append(ss.pop()).append(" ");
        }
        System.out.print(sb);
    }
}
