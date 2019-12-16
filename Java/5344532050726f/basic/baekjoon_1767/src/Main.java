import java.util.*;

public class Main {
    static final int mod = 1000001;
    static int N,M,K;
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        dp = new long[N+1][M+1][K+1];

        for(int i=0;i<=N;++i){
            for(int j = 0 ; j<=M;++j){
                for(int k = 0; k<=K;++k){
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(rec(N,M,K));
    }
    private static long rec(int x, int y, int k){
        if(x<0||y<0||k<0) return 0;
        if(k==0) return 1;
        if(dp[x][y][k] != -1) return dp[x][y][k];

        return dp[x][y][k] =  (rec(x - 1, y, k) + rec(x - 1, y - 1, k - 1) * y
                + (rec(x - 1, y - 2, k - 2) * y * (y - 1) / 2) + (rec(x - 2, y - 1, k - 2) * y * (x - 1))) % mod;

    }
}
