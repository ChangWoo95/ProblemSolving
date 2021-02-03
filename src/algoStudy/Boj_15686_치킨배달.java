package algoStudy;

import java.io.*;
import java.util.*;
/**
* @since 2021-02-02
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/15686
* @time 276ms
* @mem  19328 KB
* @caution
*/

public class Boj_15686_치킨배달 {
    static class Node {
        int x;
        int y;
        Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static List<Node> myHome = new ArrayList<>();
    static List<Node> chikenHome = new ArrayList<>();
    static int[] comb;
    static int chiRoad = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        comb = new int[m];
        int num;

        for(int i =0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                num = Integer.parseInt(st.nextToken());
                if(num == 1) myHome.add(new Node(i, j));
                else if(num == 2) chikenHome.add(new Node(i, j));
            }
        }
        chikenComb(0, 0);
        System.out.println(chiRoad);
    }
    static void chikenComb(int depth, int start){
        if(depth == m){ // 조건에 부합하면
            int result = 0;
            for(int i =0; i< myHome.size(); i++){
                int tmp = Integer.MAX_VALUE;
                for(int j = 0; j < comb.length; j++) // 각 집의 조건에 부합하는 치킨 거리 구함
                    tmp = Math.min(tmp, Math.abs(myHome.get(i).x - chikenHome.get(comb[j]).x) + Math.abs(myHome.get(i).y - chikenHome.get(comb[j]).y));
                result += tmp;
            }
            chiRoad = Math.min(chiRoad, result); // 도시의 치킨거리의 최솟값 구하기
            return;
        }
        for(int i = start; i < chikenHome.size(); i++){ // 치킨집에 대한 조합
            comb[depth] = i;
            chikenComb(depth+1, i+1);
        }
    }
}
