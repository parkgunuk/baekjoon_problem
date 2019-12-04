import java.util.*;

public class Main {
    static long[][] Dp;
    static final long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Dp = new long[101][11];
        long sum = 0;
        for(int i =1;i<10;++i){
            Dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++){
            for (int j = 0; j < 10; j++){
                if (j == 0)
                    Dp[i][0] = Dp[i - 1][1] % mod;
                else if (j == 9)
                    Dp[i][9] = Dp[i - 1][8] % mod;
                else
                    Dp[i][j] = (Dp[i - 1][j - 1] + Dp[i - 1][j + 1]) % mod;
            }
        }
        for (int i = 0; i < 10; i++)
            sum = (sum + Dp[N][i]) % mod;
        System.out.println(sum%mod);
    }
}