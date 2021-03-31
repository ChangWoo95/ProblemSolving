package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_상호의배틀필드 {
    static class Node {
        int x;
        char ch;
        Node(int x, char ch){
            this.x = x;
            this.ch = ch;
        }
    }
    static int h,w;
    static char[][] map;
    static int op;
    static Map<Character, Node> dir = new HashMap<>();
    static int[][] deltas = { {0,1}, {0,-1}, {-1,0},{1,0} };
    static char direction;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        dir.put('R', new Node(0, '>'));
        dir.put('L', new Node(1, '<'));
        dir.put('U', new Node(2, '^'));
        dir.put('D', new Node(3, 'v'));

        for(int t = 1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            int x= 0,y= 0;

            for(int i =0; i< h; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j =0; j < w; j++){
                    if(map[i][j] == '<') { direction = 'L'; x= i; y= j; map[i][j]='.';}
                    else if(map[i][j] == '>'){ direction = 'R'; x= i; y= j; map[i][j]='.';}
                    else if(map[i][j] == '^') { direction = 'U'; x= i; y= j; map[i][j]='.';}
                    else if(map[i][j] == 'v'){ direction = 'D'; x= i; y= j; map[i][j]='.'; }
                }
            }
            op = Integer.parseInt(br.readLine());
            char[] oplist = br.readLine().toCharArray();
            play(x, y, oplist);
            sb.append("#"+t+" ");
            for(int i =0; i <h; i++){
                for(int j = 0; j < w; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
    static void play(int cx, int cy, char[] oplist){
        for(int i =0; i < oplist.length; i++){
            if(oplist[i] == 'S') {
                int x = cx, y = cy;
                while(x >= 0 && x < h && y>= 0 && y < w){
                    if(map[x][y] == '#') break;
                    else if(map[x][y] == '*') { map[x][y] = '.'; break;}
                    x += deltas[dir.get(direction).x][0]; y+=deltas[dir.get(direction).x][1];
                }
                continue;
            }
            int nx = cx + deltas[dir.get(oplist[i]).x][0];
            int ny = cy + deltas[dir.get(oplist[i]).x][1];
            direction = oplist[i];
            if(!isIn(nx, ny)) continue;
            if(map[nx][ny] == '.'){
                cx = nx;
                cy = ny;
            }
        }
        map[cx][cy] = dir.get(direction).ch;
    }
    static boolean isIn(int nx, int ny){
        return nx>=0 && nx <h && ny >=0 && ny < w;
    }
}
