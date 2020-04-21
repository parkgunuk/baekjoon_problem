import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int v, w;
        private Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    private static int N, M;
    private static PriorityQueue<Node> pq;
    private static ArrayList<Integer>[] nodes;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        pq = new PriorityQueue<>();
        dist = new int[N+1];
        nodes = new ArrayList[N+1];

        Arrays.fill(dist, -1);

        for(int i=0; i<N+1; i++) nodes[i] = new ArrayList();


        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node n = pq.poll();

            for(int i : nodes[n.v]){
                if(dist[i] != -1) continue;

                pq.add(new Node(i, n.w+1));
                dist[i] = n.w+1;
            }
        }

        int idx = N;
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for(int i = 2 ; i <= N ; ++i){
            if(dist[i] > max) {
                idx = N;
                idx = Math.min(idx,i);
                max = dist[i];
            }
        }

        for(int i = 2 ; i <= N ; ++i){
            if(dist[i] == max) cnt++;
        }

        System.out.println(idx+" "+max+" "+cnt);
    }
}
