import java.util.*;
import java.io.*;
public class Main {
    static int V,E,K;
    static class Node implements Comparable<Node>{
        int end;
        int val;

        public Node(int end, int val){
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        int[] distance = new int[V+1];
        boolean[] check = new boolean[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        ArrayList<Node>[] list = new ArrayList[V+1];
        for(int i = 0 ; i<=V;++i) list[i] = new ArrayList<>();

        for(int i = 0; i<E;++i){
            StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());

            list[u].add(new Node(v, w));
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K,0));
        distance[K] = 0;

        while(!q.isEmpty()){
            int cur = q.poll().end;
            if(check[cur]) continue;
            check[cur] = true;

            for(Node t : list[cur]){
                if(distance[t.end] > t.val + distance[cur]){
                    distance[t.end] = t.val + distance[cur];
                    q.add(new Node(t.end, distance[t.end]));
                }
            }
        }
        for(int i = 1 ;i<=V;++i){
            if(!check[i]) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

}
