import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int[][] dp = new int[N+1][N+1];
        int[] arr = new int[2*N];

        for(int i = 0 ; i< N; ++i){
            st = new StringTokenizer(br.readLine());
            arr[i] = stoi(st.nextToken());
            arr[i+1] = stoi(st.nextToken());
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);

            }
        }
        System.out.println(dp[1][N]);
    }
}