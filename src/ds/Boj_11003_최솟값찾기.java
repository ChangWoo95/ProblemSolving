package ds;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<Point> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());


        for(int i = 1 ; i <= n; i++){
            int x = Integer.parseInt(st.nextToken());

            if(!dq.isEmpty() && dq.peekFirst().y <= i - l) dq.pollFirst(); // 이번 분기의 조건(i - l)보다 인덱스가 작거나 같다면 빼내기
            while(!dq.isEmpty() && dq.peekLast().x > x) dq.pollLast(); // 항상 맨뒤에 존재하는 요소값은 젤 크게 만들어주기
            dq.addLast(new Point(x, i)); // 추가하기
            sb.append(dq.peekFirst().x).append(" ");
        }
        System.out.print(sb);
    }
}
