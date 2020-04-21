import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int[] score = new int[s+1];

        for(int i = 1 ; i<s+1;++i) score[i] = Integer.parseInt(br.readLine());

        int sum = score[s];
        int[] dp = new int[s+1];

        dp[1] = score[1];
        if(s >= 2) dp[2] = dp[1]+score[2];

        for(int i=3; i<=s; i++){
            dp[i] = Math.max(dp[i-2]+score[i],dp[i-3]+score[i-1]+score[i]);
        }

        System.out.println(dp[s]);
    }
}
