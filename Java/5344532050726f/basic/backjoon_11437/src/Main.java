//LCA
import java.util.*;

public class Main {
    static int[] parent;
    static int N;
    static LinkedList<Integer>[] tree;
    static boolean visited[];
    static int[] d;
    static final int Root = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        tree = new LinkedList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];
        d = new int[N+1];

        for(int i = 0; i<=N;++i) tree[i] = new LinkedList<Integer>();

        for(int i = 0; i<N-1;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();

            tree[a].add(b);
            tree[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(Root);

        parent[Root] = Root;
        d[Root] = Root;

        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;
            for(int i : tree[node]) {
                if(parent[i] == 0){
                    q.add(i);
                    parent[i] = node;
                    d[i] = d[node]+1;
                }
            }
        }
        int M = sc.nextInt();

        while(M-->0){
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(LCA(c,d));
        }
    }
    static int LCA(int x, int y){
        if(d[x] > d[y]) {
            int t = x;
            x = y;
            y = t;
        }
        while(d[x] != d[y]){
            y = parent[y];
        }
        if( x == y) return x;
        else{
            while(parent[x] != parent[y]){
                x = parent[x];
                y = parent[y];
            }
            return parent[x];
        }
    }

}
