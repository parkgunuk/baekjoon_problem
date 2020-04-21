import java.io.*;
import java.util.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int v, dist;
        private Node(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }

    static ArrayList<Node>[] tree;
    static int[][] parent;
    static int[] height, dist;
    static boolean[] visited;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());

        H = (int) Math.ceil(Math.log(N) / Math.log(2));

        parent = new int[N + 1][H + 1];
        visited = new boolean[N + 1];
        height = new int[N + 1];
        dist = new int[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<Node>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        dfs(1,0,0);
        for (int h = 1; h <= H; h++)
            for (int v = 1; v <= N; v++)
                parent[v][h] = parent[parent[v][h - 1]][h - 1];

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int lca = LCA(u, v);
            System.out.println(dist[u] + dist[v] - 2 * dist[lca]);
        }

    }

    private static int LCA(int x, int y) {
        if (height[x] > height[y]) {
            int temp = y;
            y = x;
            x = temp;
        }

        for (int i = H; i >= 0; i--)
            if (height[y] - height[x] >= (1 << i))
                y = parent[y][i];

        if (x == y)
            return x;

        for (int i = H; i >= 0; i--) {
            if (parent[x][i] == parent[y][i])
                continue;
            x = parent[x][i];
            y = parent[y][i];
        }
        return parent[x][0];
    }

    private static void dfs(int u, int h, int d) {
        visited[u] = true;
        height[u] = h;

        for (Node n : tree[u]) {
            if (!visited[n.v]) {
                parent[n.v][0] = u;
                dist[n.v] = d + n.dist;
                dfs(n.v, h + 1, dist[n.v]);
            }
        }
    }
}
