import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N,P;
    static int[][] W;
    static int[] dp;
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        W = new int[N][N];
        dp = new int[1<<16];
        Arrays.fill(dp,-1);

        for(int r = 0 ; r<N;++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c<N;++c){
                W[r][c] = stoi(st.nextToken());
            }
        }
        String[] isOff = br.readLine().split("");
        P = stoi(br.readLine());

        int cnt = 0;
        int onOffset = 0;
        for(int i = 0;i<isOff.length;++i){
            if(isOff[i].equals("Y")) {
                cnt++;
                onOffset |= (1<<i);
            }
        }
        int ans = TSP(cnt,onOffset);
        if(ans == MAX) System.out.println(-1);
        else System.out.println(ans>=0?ans:-1);
    }

    private static int TSP(int cnt, int visited) {
//        if(cnt==0) return -1;
        if(cnt >= P || P==0) return 0;
        if(dp[visited] != -1 )return dp[visited];

        int res = MAX;
        for(int i = 0; i<N;++i){
            if((visited & (1<<i))==0) continue;
            for(int j = 0; j<N;++j){
                if((visited & (1<<j))>0)continue;
                res = Math.min(res, TSP(cnt+1, visited|(1<<j))+W[i][j]);
            }
        }
        return dp[visited] = res;
    }
}