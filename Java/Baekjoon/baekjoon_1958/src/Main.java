import java.util.*;
import java.io.*;
public class Main {
    static int[][][] dp;
    static char[] s1, s2, s3;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        s3 = br.readLine().toCharArray();

        dp = new int[s3.length+1][s2.length+1][s1.length+1];

        for(int k = 1; k<=s3.length;++k) {
            for (int i = 1; i <= s2.length; ++i) {
                for (int j = 1; j <= s1.length; ++j) {

                    if (s1[j - 1] == s2[i - 1] && s2[i-1] == s3[k-1]) dp[k][i][j] = dp[k - 1][i - 1][j - 1] + 1;
                    else dp[k][i][j] = Math.max(dp[k - 1][i][j], Math.max(dp[k][i-1][j], dp[k][i][j-1]));
                }
            }
        }

        System.out.println(dp[s3.length][s2.length][s1.length]);
    }
}