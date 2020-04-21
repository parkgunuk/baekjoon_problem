import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    private static class Node{
        int v, w;
        private Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 1; i <= N ; ++i) tree[i] = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i = 0 ; i<N;++i){
            st = new StringTokenizer(br.readLine());
            int idx = stoi(st.nextToken());
            while(true){
                int a = stoi(st.nextToken());
                if(a < 0 ) break;
                int b = stoi(st.nextToken());
                tree[idx].add(new Node(a,b));
            }
        }
        Node s = dfs(1,0);
        Arrays.fill(visited, false);
        Node e = dfs(s.v, 0);

        System.out.println(e.w);
    }

    private static Node dfs(int v, int s) {
        visited[v] = true;
        Node N = new Node(v, s);

        for (Node n : tree[v]) {
            if (visited[n.v]) continue;
            Node ret = dfs(n.v, s + n.w);
            if (N.w < ret.w)
                N = ret;
        }
        return N;
    }
}
