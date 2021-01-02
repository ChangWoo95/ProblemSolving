package general;

public class Boj_15596_정수N개의합 {
    class Test{
        long sum(int[] a){
            long sumA = 0;
            for(int i =0; i < a.length; i++){
                sumA += a[i];
            }
            return sumA;
        }
    }
}
