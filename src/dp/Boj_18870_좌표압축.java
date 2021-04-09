package dp;

import java.io.*;
import java.util.*;

public class Boj_18870_좌표압축 {
    static List<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] org = new int[n];
        Set<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i =0; i <n; i++){
            org[i] = Integer.parseInt(st.nextToken());
            s.add(org[i]);
        }
        list = new ArrayList<>(s);
        Collections.sort(list);
        for(int i = 0; i < org.length; i++){
            int cnt = lowerBound(org[i]);
            sb.append(cnt).append(" ");
        }
        System.out.print(sb);
    }
    public static int lowerBound(int target){
        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            int mid = (left + right ) / 2;
            if(list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
