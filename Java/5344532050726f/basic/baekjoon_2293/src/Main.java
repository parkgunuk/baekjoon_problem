import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for(int i = 0 ; i<N;++i){
            coin[i] = sc.nextInt();
        }
        int[] dp = new int[K+1];
        dp[0] = 1;
        for(int i = 0; i<N;++i){
            for(int j = 1;j<=K;++j) {
                if(j-coin[i] >= 0) dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}
