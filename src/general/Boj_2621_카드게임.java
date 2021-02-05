package general;

import java.io.*;
import java.util.*;

public class Boj_2621_카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] colors = new int[4]; // 색상
        int[] numbers = new int[11]; // 숫자
        int[] cnts = new int[6]; // 같은 숫자의 갯수
        int[] sameCol = new int[6]; // 같은 색상의 갯수

        int maxN = Integer.MIN_VALUE;
        int n;
        int serial = 0;
        char c;
        int result = 0;

        for(int i =0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            c = st.nextToken().charAt(0);
            n = Integer.parseInt(st.nextToken());
            if(c == 'R') colors[0]++;
            else if(c == 'B') colors[1]++;
            else if(c == 'Y') colors[2]++;
            else colors[3]++;
            numbers[n]++;
        }
        for(int i =0; i < 4; i++){ // 같은 색상의 color 탐색
            if(colors[i] == 1) sameCol[1]++;
            else if(colors[i] == 2) sameCol[2]++;
            else if(colors[i] == 3) sameCol[3]++;
            else if(colors[i] == 4) sameCol[4]++;
            else if(colors[i] == 5) sameCol[5]++;
        }

        for(int i =1; i<=6; i++){ // 스트레이트가 가능한지 여부
            if(numbers[i] == 1 && numbers[i+1] == 1 && numbers[i+2] == 1 && numbers[i+3] == 1 && numbers[i+4] == 1) serial = 1;
        }
        
        int sfour = 0, sthree = 0;
        int[] stwo = new int[2];

        for(int i =1; i<= 9; i++){
            if(numbers[i] > 0) maxN = i;
            if(numbers[i] == 1) cnts[1]++;
            else if(numbers[i] == 2){
                cnts[2]++;
                if(cnts[2] == 1) stwo[0] = i;
                else stwo[1] = i;
            }
            else if(numbers[i] == 3) {
                cnts[3]++;
                sthree = i;
            }
            else if(numbers[i] == 4) {
                cnts[4]++;
                sfour = i;
            }
            else if(numbers[i] == 5) cnts[5]++;
        }

        if(sameCol[5] == 1 && serial == 1) result  = maxN + 900;
        else if(cnts[4] == 1) result = sfour +800;
        else if(cnts[3] == 1 && cnts[2] == 1) result = (sthree * 10) + stwo[0] + 700;
        else if(sameCol[5] == 1) result = maxN + 600;
        else if(serial == 1) result = maxN + 500;
        else if(cnts[3] == 1) result = sthree + 400;
        else if(cnts[2] == 2) result = Math.max(stwo[0], stwo[1]) *10 + Math.min(stwo[0],stwo[1]) + 300;
        else if(cnts[2] == 1) result = stwo[0] + 200;
        else result = maxN + 100;
        System.out.println(result);
    }
}
