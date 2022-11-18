package day20221119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * fileName       : Boj25966_배찬우는배열을좋아해
 * author         : changwoo95
 * date           : 2022-11-19
 * description    : 간단하지만 배열의 주소값 개념을 알고 있어야 쉽게 해결할 수 있는 문제
 *                  자바의 배열은 reference type이기에 heap에 저장이 된다.
 *                  하지만 해당 영역의 주소값 자체는 stack에 저장이 되는데
 *                  여기서 내가 헷갈린 부분은 주소값 설정에서 뭔가 착오를 했었다.
 *                  하지만 참조하는 주소값을 swap하는 것이기에 tmp 배열을 통해 swap이 가능하다.
 **/
public class Boj25966_배찬우는배열을좋아해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = 0;

            switch (oper) {
                case 0:
                    k = Integer.parseInt(st.nextToken());
                    arr[i][j] = k;
                    break;
                case 1:
                    for (int y = 0; y < n; ++y) {
                        int tmp = arr[i][y];
                        arr[i][y] = arr[j][y];
                        arr[j][y] = tmp;
                    }

                    break;
                default:
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                sb.append(arr[x][y]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
