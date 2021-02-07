package algoStudy;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Boj_2580_스도쿠 {
    static List<Point> list = new ArrayList<>();
    static int[][] map = new int[9][9];
    static StringBuilder sb = new StringBuilder();
    static boolean[] find = new boolean[10];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i =0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) list.add(new Point(i, j));
            }
        }
        play(0);
    }

    static void play(int depth){
        if(depth == list.size()){ // 문제없이 통과하면 정답!
            for(int i =0; i < 9; i++){
                for(int j = 0; j < 9; j++)
                    sb.append(map[i][j]).append(' ');
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }
        for(int j = 1; j <= 9; j++){
            int x = list.get(depth).x; int y = list.get(depth).y;
            map[x][y] = j;
            if(isRow(x) && isCol(y) && isMatrix(x, y)) {
                play(depth + 1);
            }
            map[x][y] = 0;
        }
    }
    static boolean isRow(int x){ // 행에 중복되는 수 있는지 확인
        Arrays.fill(find,false);
        for(int i =0; i < 9; i++){
            if(map[x][i] == 0) continue;
            if(find[map[x][i]]) return false;
            else find[map[x][i]] = true;
        }
        return true;
    }
    static boolean isCol(int y) { // 열에 중복되는 수 있는지 확인
        Arrays.fill(find,false);
        for(int i =0; i < 9; i++){
            if(map[i][y] == 0) continue;
            if(find[map[i][y]]) return false;
            else find[map[i][y]] = true;
        }
        return true;
    }
    static boolean isMatrix(int x, int y) { // 정방형 체크
        Arrays.fill(find, false);
        for(int i =(x/3)*3; i <= (x/3)*3 + 2; i++){
            for(int j =(y/3)*3; j <= (y/3)*3 + 2; j++ ){
                if(map[i][j] == 0) continue;
                if(find[map[i][j]]) return false;
                else find[map[i][j]] = true;
            }
        }
        return true;
    }
}
