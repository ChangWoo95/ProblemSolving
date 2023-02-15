import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int docNum = Integer.parseInt(st.nextToken());

            Queue<int[]> docQueue = new LinkedList<>();
            int[] priorityArr = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0 ; i < n; ++i) {
                int priority = Integer.parseInt(st.nextToken());
                priorityArr[i] = priority;
                docQueue.offer(new int[] {priority, i});
            }

            Arrays.sort(priorityArr);

            int answer = 1;
            int priorityIdx = n-1;
            while (!docQueue.isEmpty()) {
                int nodePriority = docQueue.peek()[0];
                int nodeIdx = docQueue.peek()[1];
                docQueue.poll();

                if (nodePriority == priorityArr[priorityIdx]) {
                    if (nodeIdx == docNum) {
                        sb.append(answer).append("\n");
                        break;
                    } else {
                        --priorityIdx;
                        ++answer;
                    }
                }

                docQueue.offer(new int[] {nodePriority, nodeIdx});
            }
        }
        System.out.println(sb);
    }
}
