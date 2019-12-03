import java.util.*;
public class Main {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new long[N+1][N+1];
        long ans = 0;
        for(int i = 1;i<=N;++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = sc.nextInt();
                if (j == 1) dp[i][j] += dp[i - 1][j];
                else if (j == i) dp[i][j] += dp[i - 1][j - 1];
                else dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i-1][j]);

                ans = ans > dp[i][j] ? ans : dp[i][j];
            }
        }
        System.out.println(ans);
    }
}
