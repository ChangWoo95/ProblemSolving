package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11651_좌표정렬하기2 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Node[] list = new Node[n];

        for(int i =0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(list, (n1, n2) -> {
            if(n1.y == n2.y) return n1.x - n2.x;
            return n1.y - n2.y;
        });
        for(int i =0; i < n; i++){
            sb.append(list[i].x).append(" ").append(list[i].y).append("\n");
        }
        System.out.print(sb);
    }
}
