import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = stoi(br.readLine());
        while(tc-->0){
            int N = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            dp = new int[N+1][N+1];

            for(int i = 0 ; i<N;++i) arr[i] = stoi(st.nextToken());

            System.out.println(cal(0,N-1));
        }
    }
    private static int cal(int left, int right){
        if(dp[left][right] != 0 ) return dp[left][right];
        int sum = 0;
        if(left==right) return arr[left];
        else {
            for(int i = left; i <=right ; i++) sum+=arr[i];
            int tmp= Math.max(sum-cal(left+1, right), sum-cal(left, right-1));
            dp[left][right]=tmp;
            return tmp;
        }
    }
}
