import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N;
    static int[][] W;
    static int[][] dp;
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        W = new int[N][N];
        dp = new int[N][1<<N];
        for(int r = 0 ; r<N;++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c<N;++c){
                W[r][c] = stoi(st.nextToken());
            }
        }
        System.out.println(TSP(0,1));
    }

    private static int TSP(int cur, int visited){
        if(visited == (1<<N)-1) {
            if(W[cur][0] != 0) return W[cur][0];
        }

        if(dp[cur][visited] != 0 )return dp[cur][visited];

        int ans = MAX;
        int bi = 2;
        for(int i=1; i<N; i++){
            if((visited&bi)==0 && W[cur][i]!=0 ){
                ans=Math.min(ans, TSP(i,visited+bi)+W[cur][i]);
            }
            bi=(bi<<1);
        }
        return dp[cur][visited] = ans;
    }
}