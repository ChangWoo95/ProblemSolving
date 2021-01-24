package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_3190_뱀 {
    static class Pos { // 뱀 몸통을 담당할 class
        int x;
        int y;
        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n, k, l;
    static int[][] board; // 움직일 map
    static List<Pos> snake;
    static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 순서대로 동, 남, 서, 북(시계방향이고 뱀은 첫 스타트가 오른쪽!)

    public static void main(String[] args) throws IOException {
        snake = new LinkedList<>();
        snake.add(new Pos(0, 0)); // 첫 시작위치

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        k = Integer.parseInt(br.readLine());
        int x,y;

        while(k --> 0) { // 사과 설정
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 1; // 사과는 1로 배정
        }
        
        l = Integer.parseInt(br.readLine());
        int[][] direction = new int[l][2]; // 시간에 따른 방향변화를 담기 위한 2차원 배열

        for(int i =0; i< l; i++) {
            st = new StringTokenizer(br.readLine());
            direction[i][0] = Integer.parseInt(st.nextToken());
            char tmp = st.nextToken().charAt(0);
            direction[i][1] = tmp == 'L'? -1 : 1; // L일 경우, -1, R일 경우 +1
        }
        int runningTime = play(0, 0, 0, direction);
        System.out.println(runningTime);
    }
    static int play(int cx, int cy, int cdir, int[][] direction) {
        int time = 0;
        int turn = 0;

        while(true) {
            time++;
            int nx = cx + deltas[cdir][0];
            int ny = cy + deltas[cdir][1];

            if(gameOver(nx, ny)) break;

            if(board[nx][ny] == 1 ) { // 다음 이동할 좌표에 사과가 있다면
                board[nx][ny] = 0; // 사과 비우기
            }
            else snake.remove(0); // 맨 뒤, 즉 꼬리부분을 줄이기

            snake.add(new Pos(nx, ny));
            cx = nx;
            cy = ny;

            if(turn < l ){
                if(time == direction[turn][0]){ // 현재 시간이 방향을 바꿀 시간이라면
                    int ndir = (direction[turn][1] + cdir) % 4; //방향전환
                    if(ndir  == -1) ndir = 3;
                    cdir = ndir;
                    turn++;
                }
            }
        }
        return time;
    }

    static boolean gameOver(int nx, int ny) {
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) return true; // 맵 벗어나면 끝
        for(int i = 0; i< snake.size(); i++) {
            if(snake.get(i).x == nx && snake.get(i).y == ny) return true; // 링크드리스트 내에 몸통(좌표)들이랑 겹치면 끝
        }
        return false;
    }
}
