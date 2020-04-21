import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static final int max = 987654321;

    static int N, M;
    static int[][] weight;
    static int[] dist;
    static boolean[] visited;
    static int s, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        M = stoi(br.readLine());

        weight = new int[N+1][N+1];
        dist = new int[N+1];
        for(int i = 0 ; i<=N ; ++i) Arrays.fill(weight[i], max);
        Arrays.fill(dist, max);
        visited = new boolean[N+1];

        for(int i = 0 ; i< M ; ++i){
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            weight[u][v] = Math.min(weight[u][v], w);
        }

        st = new StringTokenizer(br.readLine());
        s = stoi(st.nextToken());
        e = stoi(st.nextToken());

        dijkstra();
        System.out.println(dist[e]);
    }

    private static void dijkstra(){

        int u, d;

        dist[s] = 0;

        for(int i = 1 ; i<=N;++i){
            d = max+1;
            u = 0;

            for(int j = 1 ; j <= N; ++j){
                if(visited[j] || dist[j] >= d) continue;
                u = j;
                d = dist[j];
            }
            for(int j = 1; j<=N;++j){
                if(dist[j] > dist[u] + weight[u][j]) dist[j] = dist[u] + weight[u][j];
            }
            visited[u] = true;
        }
    }
}