import java.util.*;
public class Main {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N+1][N];
        for(int i = 1;i<=N;++i){
            dp[0][i] = sc.nextInt();
        }

    }
}
