package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2529_부등호 {
    static char[] output;
    static boolean[] visited = new boolean[10];
    static char[] list;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        output = new char[n+1];
        list = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n; ++i){
            list[i] = st.nextToken().charAt(0);
        }
        maxPerm(0, 0);
        flag = false;
        Arrays.fill(visited, false);
        minPerm(0, 0);
        System.out.print(sb);
    }

    static void maxPerm(int depth, int idx){
        if(depth == n+1){
            sb.append(new String(output)).append("\n");
            flag = true;
            return;
        }
        for(int i = 9; i >= 0; --i){
            if(!visited[i]){
                if(depth != 0 && ( (list[idx] == '<' && output[depth-1] - '0' > i) || (list[idx] == '>' && output[depth-1] -'0' < i) ) ) continue;
                visited[i] = true;
                output[depth] = (char) (i + '0');
                maxPerm(depth + 1, (depth== 0)? idx :idx + 1);
                if(flag) return;
                visited[i] = false;
            }
        }
    }
    static void minPerm(int depth, int idx){
        if(depth == n+1){
            sb.append(new String(output)).append("\n");
            flag = true;
            return;
        }
        for(int i = 0; i <= 9; ++i){
            if(!visited[i]){
                if(depth != 0 && ( (list[idx] == '<' && output[depth-1] - '0' > i) || (list[idx] == '>' && output[depth-1] -'0' < i) ) ) continue;
                visited[i] = true;
                output[depth] = (char) (i + '0');
                minPerm(depth + 1, (depth== 0)? idx :idx + 1);
                if(flag) return;
                visited[i] = false;
            }
        }
    }
}
