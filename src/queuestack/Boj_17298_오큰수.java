package queuestack;

import java.io.*;
import java.util.*;

public class Boj_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> ss = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] idx = new int[n];
        boolean flag = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        for (int i = list.length - 1; i >= 0; i--) {
            if (ss.isEmpty()) idx[i] = -1;
            else {
                flag = false;
                if (list[i] < ss.peek()) idx[i] = ss.peek();
                else {
                    while (!ss.isEmpty()) {
                        ss.pop();
                        if (!ss.isEmpty() && list[i] < ss.peek()) {
                            idx[i] = ss.peek();
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) idx[i] = -1;
                }
            }
            ss.push(list[i]);
        }
        for (int x : idx) sb.append(x).append(" ");
        System.out.println(sb);
    }
}
