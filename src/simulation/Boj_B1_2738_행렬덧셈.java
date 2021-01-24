package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_B1_2738_행렬덧셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr1 = new int[n][m];
        int [][] arr2 = new int[n][m];

        for(int i = 0; i< n; i++) {
            StringTokenizer st2 =new StringTokenizer(br.readLine());
            for(int j = 0; j < m ; j++){
                arr1[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i = 0; i< n; i++) {
            StringTokenizer st2 =new StringTokenizer(br.readLine());
            for(int j = 0; j < m ; j++){
                arr2[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int i = 0;i <n; i++){
            for (int j = 0 ;j < m; j++){
                System.out.printf("%d ",arr1[i][j] + arr2[i][j]);
            }
            System.out.println();
        }

    }
}
