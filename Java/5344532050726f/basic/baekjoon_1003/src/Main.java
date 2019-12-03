import java.util.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[41][2];
        init();
        for(int i = 0; i<N;++i){
            int q = sc.nextInt();

            System.out.println(dp[q][0] + " "+ dp[q][1]);

        }
    }
    static void init(){
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2 ;i<dp.length;++i){
            for(int j = 0; j<2;++j){
                dp[i][j] = dp[i-1][j]+dp[i-2][j];
            }
        }
    }
}
