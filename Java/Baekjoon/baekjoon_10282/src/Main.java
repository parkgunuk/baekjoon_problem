import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int i, d;
        private Node(int i, int d){
            this.i = i;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d-o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = stoi(br.readLine());

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int d = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            ArrayList<Node>[] graph = new ArrayList[n+1];
            int[] dist = new int[n+1];

            for(int i = 0 ; i < n+1 ; ++i) graph[i] = new ArrayList<>();

            while(d-->0){
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                int s = stoi(st.nextToken());

                graph[b].add(new Node(a,s));
            }

            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[c] = 0;
            pq.add(new Node(c, dist[c]));

            while(!pq.isEmpty()) {
                Node node = pq.poll();

                for(Node node1 : graph[node.i]) {
                    if(dist[node1.i] > dist[node.i] + node1.d) {
                        dist[node1.i] = dist[node.i] + node1.d;
                        pq.add(new Node(node1.i, dist[node1.i]));
                    }
                }
            }

            int count = 0;
            int time = 0;
            for(int i = 1 ; i <= n ; ++i) {
                if(dist[i] != Integer.MAX_VALUE) count++;
            }
            for(int i = 1 ; i <= n ; ++i) {
                if(dist[i] != Integer.MAX_VALUE && dist[i] > time) time = dist[i];
            }

            System.out.println(count + " " + time);
        }
    }
}
