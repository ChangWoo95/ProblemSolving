package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj2866_문자열잘라내기 {

    public static int r,c;
    public static char[][] table;

    public static void main(String[] args) throws IOException {
        input();
        int answer = upperBound();
        System.out.println(answer);
    }

    public static int upperBound() {
        int low = 0;
        int high = r;
        while(low < high) {
            int mid = (low + high) / 2;
            if(!isDuplicated(mid)) high = mid;
            else low = mid + 1;
        }
        return high -1;
    }

    public static boolean isDuplicated(int mid) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < c; ++i) {
            String s = makeString(i, mid, r);
            if(!set.contains(s)) set.add(s);
            else return false;
        }
        return true;
    }

    public static String makeString(int col, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; ++i) {
            sb.append(table[i][col]);
        }
        return sb.toString();
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        table = new char[r][c];

        for(int i = 0 ; i <r; ++i) {
            String row = br.readLine();
            for(int j = 0 ; j < c; ++j) {
                table[i][j] = row.charAt(j);
            }
        }

    }
}
