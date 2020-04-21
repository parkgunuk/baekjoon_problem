import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int r, c, w;
        private Node(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    private static int N;
    private static int[] dist;
    private static int[][] map, dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 1;
        while(true){
            N = stoi(br.readLine());
            if(N == 0) break;

            dist = new int[N*N+1];
            Arrays.fill(dist, 987654321);
            map = new int[N+1][N+1];
            pq = new PriorityQueue<>();

            for(int i = 0 ; i < N ; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < N ; ++j){
                    map[i][j] = stoi(st.nextToken());
                }
            }
            dijkstra();
            System.out.println("Problem "+(cnt++)+": "+dist[N*N-1]);
        }
    }

    private static void dijkstra(){
        pq.add(new Node(0,0, map[0][0]));
        dist[0] = map[0][0];

        while(!pq.isEmpty()){
            Node n = pq.poll();

            for(int i = 0 ; i < 4 ; ++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if( nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if(dist[nr * N + nc] > dist[n.r * N + n.c] + map[nr][nc]){
                    dist[nr * N + nc] = dist[n.r * N + n.c] + map[nr][nc];
                    pq.add(new Node(nr, nc, dist[nr * N + nc]));
                }
            }
        }
    }
}
