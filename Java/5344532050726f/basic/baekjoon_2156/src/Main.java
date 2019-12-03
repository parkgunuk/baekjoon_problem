import java.util.*;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N+1];
        arr = new int[N+1];

        for(int i = 1 ;i<=N;++i){
            arr[i] = sc.nextInt();
        }
        //dp
        if(N>=1) dp[1] = arr[1];
        if(N>=2) dp[2] = arr[1]+arr[2];
        if(N>=3){
            for(int i = 3;i<=N;++i){
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));;
            }
        }
        System.out.println(dp[N]);

    }

}
