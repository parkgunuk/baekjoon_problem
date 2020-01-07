import java.util.*;

public class Main {
    static long[] dp = new long[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<91;++i) dp[i] = dp[i-2]+dp[i-1];

        System.out.println(dp[N]);
    }
}
