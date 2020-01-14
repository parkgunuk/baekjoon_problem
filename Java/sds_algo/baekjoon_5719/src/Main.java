import java.util.*;
import java.io.*;
/*

1) 다익스트라로 최단경로를 구한다.
2) 최단경로를 이루는 노드를 다 지운다.
3) 다시 다익스트라를 구한다.

 */
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static class Node implements Comparable<Node>{
        int now, cost;
        Node(int now, int cost){
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    static int[][] map;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static int N,M,S,D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            if(N == 0 && M == 0) break;
            st = new StringTokenizer(br.readLine());
            S = stoi(st.nextToken());
            D = stoi(st.nextToken());

            map = new int[N+1][N+1];
            dist = new int[N+1];
            pq = new PriorityQueue<>();

            for(int i = 0 ; i< M;++i){
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());
                int p = stoi(st.nextToken());

                map[u][v] = p;
            }
            dijkstra();
            deleteEdge();
            dijkstra();

            System.out.println(dist[D]);
        }
    }
    private static void dijkstra(){
        Arrays.fill(dist,-1);
        pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if (dist[n.now] == -1) {
                dist[n.now] = n.cost;
                for (int i = 0; i < N; i++) {
                    if (map[n.now][i] != 0 && dist[i] == -1) {
                        pq.add(new Node(i, n.cost + map[n.now][i]));
                    }
                }
            }
        }
    }
    private static void deleteEdge(){
        Queue<Integer> q = new LinkedList<>();
        q.add(D);
        while(!q.isEmpty()){
            int here = q.poll();
            for (int i = 0; i < N; i++) {
                if (dist[here] == dist[i] + map[i][here] && map[i][here] != 0) {
                    map[i][here] = 0;
                    q.add(i);
                }
            }
        }

    }
}
