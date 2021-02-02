import java.io.*;
import java.util.*;
/**
* @since 2021-02-02
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/1920
* @time 780ms
* @mem 43396KB
* @caution 일반적으로 1초(1억번 연산)를 그냥 초과해버리는 문제들은 이분탐색으로 접근하자!
*/

public class Boj_1920_수찾기 {
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new int[n];

        for(int i =0; i< n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list); // 이분탐색을 위한 정렬
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num = 0;
        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            biSearch(num);
        }
        System.out.print(sb);
    }
    static void biSearch(int num){
        int low, high, mid;
        low = 0;
        high = list.length-1;
        while(low <= high) {
            mid = (low+high) / 2;
            if(list[mid] == num){
                sb.append(1).append('\n');
                return;
            }
            else if(list[mid] > num) high = mid - 1;
            else low = mid + 1;
        }
        sb.append(0).append('\n');
    }
}
