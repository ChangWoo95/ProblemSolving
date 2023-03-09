import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11723_집합 {
    public static Set<Integer> mySet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(m --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int num = 0;

            switch(oper) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    if (!isExist(num)) {
                        mySet.add(num);
                    }
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (isExist(num)) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if (isExist(num)) {
                        mySet.remove(num);
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (mySet.contains(num)) {
                        mySet.remove(num);
                    } else {
                        mySet.add(num);
                    }
                    break;
                case "all":
                    mySet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    mySet.clear();
                    break;
                default:

            }
        }

        System.out.println(sb);
    }

    public static boolean isExist(int num) {
        return mySet.contains(num);
    }
}
