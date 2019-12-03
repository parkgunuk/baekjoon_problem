import java.util.*;
public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N];
        int[] arr = new int[N];
        int max = 0;
        for(int i = 0;i<N;++i){
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        max = arr[0];

        for(int i =1;i<N;++i){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }
}
