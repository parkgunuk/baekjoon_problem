import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dp = new int[N+1][10];
        Arrays.fill(dp[1],1);
        final int mod = 10007;

        for(int i = 2; i<=N;++i){
            for(int j = 0;j<=9;++j){
                for(int k = j; k<=9;++k){
                    dp[i][k] += dp[i-1][j];
                    dp[i][k] %= mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<10;++i){
            ans += dp[N][i];
        }
        System.out.println(ans%mod);
    }
}
