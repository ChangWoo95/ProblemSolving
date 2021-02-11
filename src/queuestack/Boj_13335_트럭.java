package queuestack;

import java.io.*;
import java.util.*;

public class Boj_13335_트럭 {
    static class Node{
        int w;
        int t;
        Node(int w, int t){
            this.w = w;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int curL = 0, time = 0, idx = 0;
        Queue<Node> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());
        while(true){
            if(!q.isEmpty() && time - q.peek().t == w) curL -= q.poll().w;
            if(idx < list.length && curL + list[idx] <= l) {
                q.add(new Node(list[idx], time));
                curL += list[idx++];
            }
            time++;
            if(q.isEmpty()) break;
        }
        System.out.print(time);
    }
}
