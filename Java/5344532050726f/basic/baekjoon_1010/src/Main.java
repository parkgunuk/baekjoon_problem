import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0;tc<T;++tc){
            int N = sc.nextInt();
            int M = sc.nextInt();

            long[] dp = new long[N+1]; // M combi N;
            dp[1] = M;
            for(int i = 2;i<=N;++i){ // M combi i
                dp[i] = dp[i-1] * (M-i+1) / i;
            }
            System.out.println(dp[N]);
        }
    }
}
