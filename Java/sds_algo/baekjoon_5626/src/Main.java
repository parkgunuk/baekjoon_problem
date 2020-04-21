import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long mod(long n){return n%1000000007;}
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new long[2][10001];
        int t = stoi(st.nextToken());

        if (t == 0 || t == -1) dp[0][0] = 1;
        else dp[0][0] = 0;

        for (int i = 2; i <= N; ++i) {
            int tmp = stoi(st.nextToken());
            // dp[0][] 홀수열
            // dp[1][] 짝수열
            if (i % 2 == 0) Arrays.fill(dp[1], 0);
            else Arrays.fill(dp[0], 0);
            /*D_ih는 A_i의 높이가 H일 수 있는 경우의 수
            * A_(i-1)이 H-1 일 경우 + A_(i-1) 이 H 인 경우 + A_(i-1) 이 H+1 인 경우
            * D_ih => h==0일 때에만 1, 나머지는 0
            * */
            if (tmp == -1) {
                //높이0은 이전거 [그대로],[내려오기]로 두가지만 가능.
                if(i%2==0) dp[1][0]=mod(dp[0][0]) + mod(dp[0][1]);
                else dp[0][0]=mod(dp[1][0]) + mod(dp[1][1]);

                for(int j=1; j<5001; j++) {

                    if(i%2==0) dp[1][j] = mod(dp[0][j-1]) + mod(dp[0][j]) + mod(dp[0][j+1]);
                    else dp[0][j] = mod(dp[1][j-1]) + mod(dp[1][j]) + mod(dp[1][j+1]);
                }

            } else if (tmp == 0) {
                if (i % 2 == 0) dp[1][0] = mod(dp[0][0]) + mod(dp[0][1]);
                else dp[0][0] = mod(dp[1][0]) + mod(dp[1][1]);

            } else{ //값을 안다 - 이번 열의 높이는 n
                if (i % 2 == 0) dp[1][tmp] = mod(dp[0][tmp - 1]) + mod(dp[0][tmp]) + mod(dp[0][tmp + 1]);
                else  dp[0][tmp] = mod(dp[1][tmp - 1]) + mod(dp[1][tmp]) + mod(dp[1][tmp + 1]);

            }
        }
        if(N%2 == 0) System.out.println(mod(dp[1][0]));
        else System.out.println(mod(dp[0][0]));
    }
}