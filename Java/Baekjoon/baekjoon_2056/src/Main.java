import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N, time;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        time = 0;
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c;
            for (int j = 0; j < b; j++) {
                c = stoi(st.nextToken());
                dp[i] = Math.max(dp[i], dp[c]);
            }
            time = Math.max(time, dp[i] += a);
        }
        System.out.println(time);
    }
}
