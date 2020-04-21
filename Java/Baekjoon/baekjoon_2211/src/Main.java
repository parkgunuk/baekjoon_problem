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

    private static final int MAX = 987654321;

    private static int N, M;
    private static int[] dist;
    private static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        dist = new int[N+1];
        list = new ArrayList[N+1];

        Arrays.fill(dist, MAX);
        for(int i = 0 ; i <= N ; ++i) list[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            list[a].add(new Node(a, b, c));
            list[b].add(new Node(b, a, c));
        }

        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(0, 1, 0));
        dist[0] = 0;
        ArrayList<Node> res = new ArrayList<>();

        while(!q.isEmpty()){
            Node n = q.poll();

            if(dist[n.v] != MAX) continue;
            dist[n.v] = n.w;

            if(n.u != 0) res.add(n);

            for(Node nn : list[n.v]){
                if(dist[nn.v] != MAX) continue;
                q.add(new Node(nn.u, nn.v, n.w + nn.w));
            }
        }

        System.out.println(res.size());
        for(Node n : res) sb.append(n.u + " " + n.v + "\n");
        System.out.println(sb.toString());
    }
}