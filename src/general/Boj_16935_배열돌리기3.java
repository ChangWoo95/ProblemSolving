package general;

import java.io.*;
import java.util.*;

public class Boj_16935_배열돌리기3 {
    static int[][] map = new int[100][100];
    static int[][] tmp = new int[100][100];
    static int n, m, cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=  new StringBuilder();
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); cnt = Integer.parseInt(st.nextToken());
        for(int i =0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int op;
        for(int i =0; i <cnt; i++){
            op = Integer.parseInt(st.nextToken());
            for(int j = 0;j < tmp.length; j++){
                Arrays.fill(tmp[j], 0);
            }
            switch(op){
                case 1:
                    transCol();
                    break;
                case 2:
                    transRow();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                     rotateLeft();
                    break;
                case 5:
                    quadrantRight();
                    break;
                case 6:
                    quadrantLeft();
                    break;
            }
        }
        for(int i =0; i <n; i++){
            for(int j = 0; j <m; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void transCol(){
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                tmp[i][j] = map[n - 1 - i][j];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }
    static void transRow(){
        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                tmp[i][m - 1- j] = map[i][j];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }
    static void rotateRight(){
        int h = n;
        n = m;
        m = h;
        for(int i=0; i< n; i++){
            for(int j =0; j <m; j++){
                tmp[i][j] = map[h - 1 - j][i];
            }
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }

    static void rotateLeft(){
        int w = m;
        m = n;
        n = w;

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                tmp[i][j] = map[j][w-1-i];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }

    static void quadrantRight(){

        int N = n / 2;
        int M = m / 2;

        for(int i=0; i<N; ++i)
            for (int j = 0; j < M; ++j)
                tmp[i][j+M] = map[i][j];

        for (int i = 0; i < N; ++i)
            for (int j = M; j < m; ++j)
                tmp[i+N][j] = map[i][j];

        for (int i = N; i < n; ++i)
            for (int j = M; j < m; ++j)
                tmp[i][j-M] = map[i][j];

        for (int i = N; i < n; ++i)
            for (int j = 0; j < M; ++j)
                tmp[i-N][j] = map[i][j];


        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }
    static void quadrantLeft(){
        int N = n / 2;
        int M = m / 2;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                tmp[i + N][j] = map[i][j];

        for (int i = N; i < n; ++i)
            for (int j = 0; j < M; ++j)
                tmp[i][j + M] = map[i][j];

        for (int i = N; i < n; ++i)
            for (int j = M; j < m; ++j)
                tmp[i - N][j] = map[i][j];

        for (int i = 0; i < N; ++i)
            for (int j = M; j < m; ++j)
                tmp[i][j-M] = map[i][j];

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = tmp[i][j];
    }
}
