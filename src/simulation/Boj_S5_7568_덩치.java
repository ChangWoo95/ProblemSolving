package simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_S5_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] people = new Point[n];
        int[] answer = new int[n];
        Arrays.fill(answer,1);

        for(int i = 0; i< n; i++) { // Point배열마다 Point객체 생성
            people[i] = new Point();
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people[i].x = weight;
            people[i].y = height;
        }

        for(int i = 0; i < n-1; i++) {
            for(int j = i+1;j < n; j++){
                if(people[i].x > people[j].x && people[i].y > people[j].y) answer[j]++;
                else if(people[i].x < people[j].x && people[i].y < people[j].y) answer[i]++;
            }
        }
        for(int ans : answer) {
            System.out.printf("%d ",ans);
        }
    }

}
