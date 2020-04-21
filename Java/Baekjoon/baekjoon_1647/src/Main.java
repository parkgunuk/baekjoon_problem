import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node> {
        int u, v, w;
        private Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int N,M;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        root = new int[N+1];
        for(int i = 1 ; i <= N ; ++i) root[i] = i;
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i = 0 ; i < M ; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            q.add(new Node(a,b,c));
        }
        int sum = 0, cnt = 0;

        while(!q.isEmpty()){
            Node n = q.poll();

            if(union(n.u, n.v)) continue;
            else{
                sum+=n.w;
//                root[n.v] = n.u;
                if(++cnt == N-2) break;
            }
        }
        System.out.println(sum);
    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        root[b] = a;
        return false;
    }

    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
