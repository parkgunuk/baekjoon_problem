import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<int[]>[] tree;
    static int[][] parents, pmin, pmax;
    static boolean[] visited;
    static int[] height;
    static int N, M, H;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        H = (int) Math.ceil(Math.log(N)/Math.log(2));
        tree = new ArrayList[N+1];
        parents = new int[N+1][H+1];
        pmin = new int[N+1][H+1];
        pmax = new int[N+1][H+1];
        visited = new boolean[N+1];
        height = new int[N+1];
        sb = new StringBuilder();

        for(int i = 1 ; i <N+1;++i) tree[i] = new ArrayList<>();
        for(int i = 0 ; i<N-1;++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            tree[A].add(new int[] {B,C});
            tree[B].add(new int[] {A,C});

        }
        dfs(1,0);
        for (int h = 1; h <= H; h++) {
            for (int v = 1; v <= N; v++) {
                pmin[v][h] = Math.min(pmin[v][h - 1], pmin[parents[v][h - 1]][h - 1]);
                pmax[v][h] = Math.max(pmax[v][h - 1], pmax[parents[v][h - 1]][h - 1]);
                parents[v][h] = parents[parents[v][h - 1]][h - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            LCA(D,E);
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int idx, int h){
        visited[idx] = true;
        height[idx] = h;

        for (int[] v : tree[idx]) {
            if (!visited[v[0]]) {
                pmin[v[0]][0] = v[1];
                pmax[v[0]][0] = v[1];
                parents[v[0]][0] = idx;
                dfs(v[0], h + 1);
            }
        }
    }

    private static void LCA(int u, int v){
        if(height[u] > height[v]){
            LCA(v,u);
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int h = H; h >= 0; h--) {
            if (height[v] - height[u] >= (1 << h)) {
                min = Math.min(min, pmin[v][h]);
                max = Math.max(max, pmax[v][h]);
                v = parents[v][h];
            }
        }
        if (u == v) {
            sb.append(min + " " + max + "\n");
            return;
        }

        for (int h = H; h >= 0; h--) {
            if (parents[u][h] != parents[v][h]) {
                min = Math.min(min, Math.min(pmin[u][h], pmin[v][h]));
                max = Math.max(max, Math.max(pmax[u][h], pmax[v][h]));
                u = parents[u][h];
                v = parents[v][h];
            }
        }

        min = Math.min(min, Math.min(pmin[u][0], pmin[v][0]));
        max = Math.max(max, Math.max(pmax[u][0], pmax[v][0]));
        sb.append(min + " " + max + "\n");


    }
}
