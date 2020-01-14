import java.util.*;

//이항계수 점화식(파스칼의 법칙)
//  n        n        n+1
//(   ) + (     ) = (     )
//  k       k+1       k+1
// 재귀를 이용해서 계산을 하자..

public class Main {
    static int[][] dp = new int[1001][1001];
    static final int MOD = 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(getBC(N,K));
    }

    private static int getBC(int N, int K){
        if (K == 0 || N == K) return 1;
        if (dp[N][K] > 0) return dp[N][K];
        dp[N][K] = getBC(N - 1, K - 1) + getBC(N - 1, K);
        return dp[N][K] % MOD;
    }
}