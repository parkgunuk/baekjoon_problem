import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 0; tc<T;++tc){
            int N = sc.nextInt();
            int[][] dp = new int[2][N+1];
            int[][] arr = new int[2][N+1];
            for(int i =0;i<2;++i){
                for(int j = 1;j<=N;++j){
                    arr[i][j] = sc.nextInt();
                }
            }
            dp[0][0] = dp[1][0] = 0;
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int i = 2; i<=N;++i){
                dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
