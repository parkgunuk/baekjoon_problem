import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static class Node implements Comparable<Node>{
        int node;
        long cost;

        Node(int node, long cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.cost - o.cost);
        }
    }

    static final int INF = 987654321;
    static int N, E;
    static long[][] weight, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        E = stoi(st.nextToken());

        weight = new long[N+1][N+1];
        dist = new long[3][N+1];
        for (int i = 0; i < 3; i++) Arrays.fill(dist[i], INF);


        for(int i = 0 ; i<E;++i){
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            weight[s][e] = w;
            weight[e][s] = w;
        }
        st = new StringTokenizer(br.readLine());
        int node1 = stoi(st.nextToken());
        int node2 = stoi(st.nextToken());
        //1~N 까지 최단거리, node1~N까지, node2~N까지 최단거리를 각자 구한다.
        dijkstra(1, 0);
        dijkstra(node1, 1);
        dijkstra(node2, 2);

        long minCost = Math.min(dist[0][node1] + dist[1][node2] + dist[2][N], dist[0][node2] + dist[2][node1] + dist[1][N]);

        System.out.println(minCost >= INF ? -1 : minCost);
    }

    private static void dijkstra(int s, int idx){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(s, 0));
        dist[idx][s] = 0;

        while (!pq.isEmpty()) {

            Node u = pq.poll();

            // 중복 제거
            if (dist[idx][u.node] < u.cost) continue;

            for (int i = 1; i <= N; i++) {
                if (weight[u.node][i] != 0) {
                    if (dist[idx][i] > dist[idx][u.node] + weight[u.node][i]) {

                        dist[idx][i] = dist[idx][u.node] + weight[u.node][i];
                        pq.add(new Node(i, dist[idx][i]));
                    }
                }
            }
        }
    }
}
