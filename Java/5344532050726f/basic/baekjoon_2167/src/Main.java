import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dp = new int[N+1][M+1];
//        int[][] map = new int[N+1][M+1]; //DP로 할때

        for(int r = 1; r<=N;r++){
            for(int c = 1; c<=M;++c){
                int t = sc.nextInt();
                dp[r][c] = dp[r][c-1]+dp[r-1][c]-dp[r-1][c-1]+t;

                //DP 없이
//                map[r][c] = t;
            }
        }
        int K = sc.nextInt();
        int ans;
        for(int i =0;i<K;++i){
            ans=0;
            int ii = sc.nextInt();
            int jj = sc.nextInt();
            int xx = sc.nextInt();
            int yy = sc.nextInt();

            ans = dp[xx][yy] - dp[xx][jj-1] - dp[ii-1][yy] + dp[ii-1][jj-1];

            // DP 없이
//            for(int r = ii;r<=xx;++r){
//                for(int c = jj; c<=yy;++c){
//                    ans+=map[r][c];
//                }
//            }

            System.out.println(ans);

        }
    }
}
