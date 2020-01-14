import java.util.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        init();
        //N! / (K! * (N-K)!)
        System.out.println(dp[N]/(dp[K]*dp[N-K]));
    }
    private static void init(){
        dp = new int[11];
        dp[0] = 1;
        for(int i = 1; i<dp.length;++i) dp[i] = dp[i-1]*i;
    }
}