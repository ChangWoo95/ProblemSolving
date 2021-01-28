package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10814_나이순정렬 {
    static class Node {
        int age;
        String name;
        int time;
        public Node(int age, String name,  int time){
            this.age = age;
            this.name = name;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int time = 0;
        Node[] list = new Node[n];

        for(int i =0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new Node(Integer.parseInt(st.nextToken()), st.nextToken(), time++);
        }
        Arrays.sort(list, (n1, n2) -> {
            if(n1.age == n2.age) return n1.time - n2.time;
            return n1.age - n2.age;
        });
        for(int i =0; i < n; i++){
            sb.append(list[i].age).append(" ").append(list[i].name).append("\n");
        }
        System.out.print(sb);
    }
}
