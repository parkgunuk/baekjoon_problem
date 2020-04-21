import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int u,v;

        private Node(int u, int v){
            this.u = u;
            this.v = v;
        }
    }

    static int N,M;
    static int[] root;
    static ArrayList<Integer>[] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        root = new int[N+1];
        ArrayList<Node> list = new ArrayList<>();
        next = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; ++i) root[i] = i;
        for(int i = 1 ; i <= N ; ++i) next[i] = new ArrayList<>();

        for(int i =  0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());

            int u = stoi(st.nextToken());
            String cmd = st.nextToken();
            int v = stoi(st.nextToken());

            if(cmd.equals("="))union(u,v);
            else list.add(new Node(u,v));
        }

        for(Node n : list){
            int u = find(n.u);
            int v = find(n.v);

            next[u].add(v);
        }

        if (isCyclic()) System.out.println("inconsistent");
        else System.out.println("consistent");
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return;
        root[a] = b;
    }

    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    // https://www.geeksforgeeks.org/detect-cycle-in-a-graph/ 참고

    private static boolean isCyclic(){
        boolean[] visited = new boolean[N+1];
        boolean[] recStack = new boolean[N+1];

        for (int i = 1; i <= N; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack){
        if (recStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        for(int n : next[i]) {
            if (isCyclicUtil(n, visited, recStack)) return true;
        }

        recStack[i] = false;
        return false;
    }
}