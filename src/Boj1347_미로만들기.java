import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1347_미로만들기 {

    public static void main(String[] args) throws IOException {
        int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dir = 2;
        char[][] map = new char[101][101];

        for (int i = 0 ; i < 101; ++i) {
            Arrays.fill(map[i], '#');
        }

        int stX = 50;
        int stY = 50;
        int minX = 50;
        int minY = 50;
        int maxX = 50;
        int maxY = 50;

        map[stX][stY] = '.';

        String opers = br.readLine();

        for (int i = 0 ; i < opers.length(); ++i) {
            char oper = opers.charAt(i);
            switch (oper) {
                case 'R':
                    dir = (dir+1) % 4;
                    break;
                case 'F':
                    stX += d[dir][0];
                    stY += d[dir][1];
                    map[stX][stY] = '.';
                    minX = Math.min(stX, minX);
                    minY = Math.min(stY, minY);
                    maxX = Math.max(stX, maxX);
                    maxY = Math.max(stY, maxY);
                    break;
                case 'L':
                    if (dir == 0) {
                        dir = 4;
                    }
                    dir = dir - 1;
                    break;
                default:

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; ++i) {
            for (int j = minY; j <= maxY; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
