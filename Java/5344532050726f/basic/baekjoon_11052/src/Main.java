import java.util.*;
public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i = 1;i<=N;++i){
            arr[i] = sc.nextInt();
        }
        for(int i = 1;i<=N;++i){
            for(int j=1;j<=i;++j){
                dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
