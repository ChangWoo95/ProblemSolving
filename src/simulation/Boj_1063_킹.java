package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1063_킹 {

    public static int[] stonePos;
    public static int[] kingPos;
    public static final int MAP_SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingLocation = st.nextToken();
        String stonelocation = st.nextToken();
        int count = Integer.parseInt(st.nextToken());
        kingPos = convertLocationToPos(kingLocation);
        stonePos = convertLocationToPos(stonelocation);

        for(int i = 0 ; i <count; ++i) {
            String oper = br.readLine();
            move(oper);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char)(kingPos[1] + 'A')).append(8 - kingPos[0]).append("\n");
        sb.append((char)(stonePos[1] + 'A')).append(8 - stonePos[0]);
        System.out.println(sb);
    }

    public static int[] convertLocationToPos(String location){
        int[] ret = new int[2];
        ret[0] = MAP_SIZE - location.charAt(1) + '0';
        ret[1] = location.charAt(0) - 'A';
        return ret;
    }

    public static void move(String oper) {
        int x = 0;
        int y = 0;


        switch (oper) {
            case "R" :
                x = 0; y = 1;
                break;
            case "L" :
                x = 0; y = -1;
                break;
            case "B" :
                x = 1; y = 0;
                break;
            case "T" :
                x = -1; y = 0;
                break;
            case "RT" :
                x = -1; y = 1;
                break;
            case "LT" :
                x = -1; y = -1;
                break;
            case "RB" :
                x = 1; y = 1;
                break;
            case "LB" :
                x = 1; y = -1;
                break;
        }
        if(isPosSame(x,y) && isIn(kingPos[0] + x, kingPos[1] + y) && isIn(stonePos[0] + x, stonePos[1] + y) ) {
            kingPos[0] += x;
            kingPos[1] += y;
            stonePos[0] += x;
            stonePos[1] += y;
        } else if(!isPosSame(x,y) && isIn(kingPos[0] + x, kingPos[1] + y)) {
            kingPos[0] += x;
            kingPos[1] += y;
        }
        return;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < MAP_SIZE && y >= 0 && y < MAP_SIZE;
    }

    public static boolean isPosSame(int x, int y) {
        return kingPos[0] + x == stonePos[0] && kingPos[1] + y == stonePos[1];
    }
}
