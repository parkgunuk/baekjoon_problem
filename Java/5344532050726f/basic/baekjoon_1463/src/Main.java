import java.util.*;

public class Main {
    static int[] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp =  new int[1000001];
        init();
        System.out.println(dp[N]);
    }
    static void init(){
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i<dp.length;++i){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if(i%2 == 0) a = dp[i/2]+1;
            if(i%3 == 0) b = dp[i/3]+1;
            c = dp[i-1]+1;

            dp[i] = getMin(a,b,c);
        }
    }
    static int getMin(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
