import java.util.*;
import java.io.*;
public class Main {
    static String s = "";
    static int[][] dp;
    static char[] s1, s2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        dp = new int[s2.length+1][s1.length+1];

        for(int i =1;i<=s2.length;++i){
            for(int j = 1; j<=s1.length;++j){
                if(s1[j-1] == s2[i-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        System.out.println(dp[s2.length][s1.length]);
        backtracking(s2.length, s1.length);
        System.out.println(s);
    }
    private static void backtracking(int m, int n){
        if(m == 0 || n == 0 ) return;
        if(dp[m][n] > dp[m-1][n-1] && dp[m][n] > dp[m-1][n] && dp[m][n] > dp[m][n-1]){
            s = String.valueOf(s1[n-1]) + s;
            backtracking(m-1,n-1);
        } else if( dp[m][n] > dp[m-1][n] && dp[m][n] == dp[m][n-1]) backtracking(m,n-1);
        else backtracking(m-1,n);
    }
}
