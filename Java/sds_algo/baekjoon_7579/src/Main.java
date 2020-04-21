import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static class Node{
        long m;
        int c;
        Node(long m, int c){
            this.m = m;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        long M = stol(st.nextToken());

        long[] memory = new long[N+1];
        int[] cost = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;++i) memory[i] = stol(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;++i) cost[i] = stoi(st.nextToken());

        Node[] apps = new Node[N+1];
        int costAll = 0;
        for(int i = 0 ; i<N;++i) {
            apps[i] = new Node(memory[i], cost[i]);
            costAll += cost[i];
        }

        long[] dp = new long[costAll+1];

        for(int i = 0; i < N; i++){
            for(int j = costAll; j >= apps[i].c; j--){
                dp[j] = Math.max(dp[j], dp[j - apps[i].c] + apps[i].m);
            }
        }
        for(int i = 0; i <= costAll; i++){
            if(dp[i] >= M){
                System.out.println(i);
                break;
            }
        }

    }
}
