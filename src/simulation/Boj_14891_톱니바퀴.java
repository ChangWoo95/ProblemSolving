package simulation;

import java.io.*;
import java.util.*;

public class Boj_14891_톱니바퀴 {
    static List<Character>[] ss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ss = new List[4];
        String s;
        for (int i = 0; i < 4; i++) {
            ss[i] = new LinkedList<>();
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) ss[i].add(s.charAt(j));
        }
        int k = Integer.parseInt(br.readLine());
        int idx, dir;
        boolean[] b = new boolean[4];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            idx = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());
            b[idx] = true;
            for (int j = idx; j < 3; j++) {
                if (ss[j].get(2) == ss[j+1].get(6)) break;
                else b[j+1] = true;
            }
            for (int j = idx; j > 0; j--) {
                if (ss[j].get(6) == ss[j-1].get(2)) break;
                else b[j-1] = true;
            }
            int tmp = dir;
            for(int j = idx; j<4; j++){
                if(b[j]) {
                    rotate(j, tmp);
                    tmp*= -1;
                }
            }
            tmp = -dir;
            for (int j = idx-1; j >= 0; j--) {
                if(b[j]) {
                    rotate(j, tmp);
                    tmp*= -1;
                }
            }
            Arrays.fill(b, false);
        }
        int ans = 0;
        for(int i = 0 ; i <4; i++){
            if(ss[i].get(0) == '0') continue;
            ans += (ss[i].get(0) - '0')<<i;
        }
        System.out.println(ans);
    }

    static void rotate(int idx, int dir) {
        char ch;
        if (dir == 1) { // 시계
            ch = ss[idx].get(7);
            ss[idx].remove(7);
            ss[idx].add(0, ch);
        } else { // 반시계
            ch = ss[idx].get(0);
            ss[idx].remove(0);
            ss[idx].add(ch);
        }
    }
}
