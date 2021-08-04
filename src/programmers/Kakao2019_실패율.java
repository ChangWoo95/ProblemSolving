package programmers;

import java.util.Arrays;

public class Kakao2019_실패율 {
    final int MAX_STAGE_COUNT = 502;
    class failure {
        double failureRate;
        int stage;

        failure(double failureRate, int stage) {
            this.failureRate = failureRate;
            this.stage = stage;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] challengersPerStage = getChallengersPerStage(N, stages);
        int[] ClearedPlayersPerStage = getClearedPlayersPerStage(N, challengersPerStage);

        failure[] failures = new failure[N];
        for(int i = 1; i <=N; ++i) {
            if(ClearedPlayersPerStage[i] == 0) failures[i-1] = new failure(0d, i);
            else {
                double failureRate = (double)challengersPerStage[i] / ClearedPlayersPerStage[i];
                failures[i - 1] = new failure(failureRate, i);
            }
        }

        Arrays.sort(failures, (x1, x2) -> {
            int comparisonOperator = Double.compare(x2.failureRate,x1.failureRate);
            if(comparisonOperator == 0) return Integer.compare(x1.stage, x2.stage);
            else return comparisonOperator;
        });

        return Arrays.stream(failures).map(s -> s.stage).mapToInt(Integer::intValue).toArray();
    }

    public int[] getChallengersPerStage(int N, int[] reachedStages) {
        int[] ret = new int[MAX_STAGE_COUNT];
        for(int i = 0 ; i < reachedStages.length; ++i) {
            int reachedStage = reachedStages[i];
            ++ret[reachedStage];
        }
        return ret;
    }

    public int[] getClearedPlayersPerStage(int N, int[] challengersPerStage) {
        int[] ret = new int[N + 2];
        ret[N + 1] = challengersPerStage[N + 1];

        for(int i = N; i >=1; --i) {
            ret[i] = ret[i+1] +  challengersPerStage[i];
        }
        return ret;
    }
}
