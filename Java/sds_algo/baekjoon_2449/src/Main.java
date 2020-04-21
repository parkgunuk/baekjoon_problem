import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static final int MAX = Integer.MAX_VALUE;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        dp = new int[N+1][N+1]; // i~j를 k색상으로 바꾸었을 때, 색을 바꾸는 최소 횟수..

        for(int i = 0 ; i<N;++i) {
            arr[i] = stoi(st.nextToken());
            Arrays.fill(dp[i],-1);
        }
        System.out.println(cal(0,N-1));

    }

    private static int cal(int i, int j){
        if(i==j) return 0;
        // 계산했었으면 그 값 return
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = MAX;

        for(int s = i; s <j;++s){
            int tmp = arr[i] != arr[s+1] ? 1 : 0;
            dp[i][j] = Math.min(dp[i][j], cal(i, s) + cal(s + 1, j) + tmp);
        }
        return dp[i][j];
    }
}