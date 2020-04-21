import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static ArrayList<Integer>[] tree;
    static int N, M, V;
    static boolean[] visited;
    static String dfs, bfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i = 1; i<=N;++i) tree[i] = new ArrayList<>();

        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }
        for(int i = 1; i<=N;++i) Collections.sort(tree[i]);

        visited = new boolean[N+1];
        dfs = String.valueOf(V);
        visited[V] = true;
        DFS(V);
        System.out.println(dfs);
        visited = new boolean[N+1];
        BFS();
        System.out.println(bfs);


    }
    private static void DFS(int cur){
        for(int i : tree[cur]){
            if(visited[i]) continue;
            visited[i] = true;
            dfs+=" "+i;
            DFS(i);
        }
    }
    private static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        bfs = String.valueOf(V);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i : tree[cur]){
                if(visited[i]) continue;
                bfs+=" "+i;
                q.add(i);
                visited[i] = true;
            }
        }
    }
}