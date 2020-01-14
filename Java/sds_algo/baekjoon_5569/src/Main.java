import java.util.*;
public class Main {
    static int[][][][] dp;
    static final int m = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        dp = new int[W+1][H+1][2][2];

        for(int i=2; i<=W; i++) dp[i][1][0][0] = 1;
        for(int i=2; i<=H; i++) dp[1][i][1][0] = 1;

        for(int i=2; i<=W; i++){
            for(int j=2; j<=H; j++){
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % m;
                dp[i][j][0][1] = dp[i-1][j][1][0];
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % m;
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }

        int ans = 0;
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) ans += dp[W][H][i][j];

        System.out.println(ans%m);
    }
}
