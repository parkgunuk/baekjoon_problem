import java.util.*;
import java.io.*;
/*
위의 양쪽 두곳에서 더 큰값을 더하면 됨.
 */
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = stoi(br.readLine());
        long[][] dp = new long[N+1][N+1];
        long ans=0;
        for(int i = 1 ; i<=N;++i){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = stoi(st.nextToken());
                if (j == 1) dp[i][j] += dp[i - 1][j];
                else if (j == i) dp[i][j] += dp[i - 1][j - 1];
                else dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i-1][j]);

                ans = ans > dp[i][j] ? ans : dp[i][j];
            }
        }
        System.out.println(ans);
    }

}
