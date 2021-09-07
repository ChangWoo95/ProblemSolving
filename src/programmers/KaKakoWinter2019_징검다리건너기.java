package programmers;

public class KaKakoWinter2019_징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1;
        int high = 200000000;
        while(low < high) {
            int mid = (low + high) / 2;

            if(!isWalkingComplete(stones, k , mid)) high = mid;
            else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
    public boolean isWalkingComplete(int[] stones, int k, int mid) {
        int count = 0;

        for(int stone : stones) {
            if(stone - mid < 0) {
                ++count;
            } else count = 0;

            if(count == k) return false;
        }
        return true;
    }



}
