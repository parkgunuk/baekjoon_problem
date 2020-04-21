import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}
    private static int choiceR(int i){ return (i+1)%N;}
    private static int choiceL(int i){ return (i+N-1)%N;}

    static int N, maxIdx, minIdx;
    static long[] A;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        A = new long[N];
        dp = new long[N+1][N+1];
        for(int i = 0 ; i<N;++i) A[i] = stol(br.readLine());
        long ans = 0 ;

        for(int i = 0; i< N;++i){
            ans = Math.max(ans, A[i]+ioi(i,i));
        }
        System.out.println(ans);
    }
    private static long ioi(int l, int r){
        if(choiceR(r) == l) return 0;
        if(A[choiceL(l)] > A[choiceR(r)]) return joi(choiceL(l), r);
        return joi(l, choiceR(r));
    }
    private static long joi(int l, int r){
        long res = dp[l][r];
        if(res != 0) return dp[l][r];
        if(choiceR(r) == l) return dp[l][r] = 0;
        return dp[l][r] = Math.max(A[choiceL(l)] + ioi(choiceL(l), r),  A[choiceR(r)] + ioi(l, choiceR(r)));
    }
}
