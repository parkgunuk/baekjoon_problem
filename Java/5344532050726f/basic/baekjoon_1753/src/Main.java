import java.util.*;
import java.io.*;
// 20000 * 20000 은 4억... 메모리 초과난다.. map으로 구현불가..
public class Main {
    static int[] distance;
    static boolean[] check;
    static List<List<Node>> list;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        distance = new int[V+1];
        check = new boolean[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        list = new ArrayList<List<Node>>();

        for(int i = 0 ; i<=V;++i){
            list.add(new ArrayList<Node>());
        }

        for(int i = 0; i<E;++i){
            StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());

            list.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(K,0));
        distance[K] = 0;

        while(!q.isEmpty()){
            int cur = q.poll().end;
            if(check[cur]) continue;
            check[cur] = true;

            for(Node t : list.get(cur)){
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
