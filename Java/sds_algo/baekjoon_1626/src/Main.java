import java.util.*;
import java.io.*;
/*
1) 빠진 Edge는 왜 빠졌는가??
    -> 그 친구를 넣으면 Cycle이 생김

2) 그 cycle에서 E의 cost보다 큰 Edge는 없다.
3) E 대신에 cycle에서 하나를 빼면 cycle 제거 => SpanningTree

==> 그렇다면, 선택된 Edge중에서 가장 큰 값을 빼면서 계산을 하면 어떨까?
 */
public class Main {
    static class Node implements Comparable<Node>{
        int u,v,w;
        public Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }
    static int[] root;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        root = new int[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Node> list = new ArrayList<>();

        int sum = 0;
        for(int i = 0 ; i<E;++i){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Node(u,v,w));
        }
        for(int j = 1 ; j<=V;++j) root[j] = j;


        int ans = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            if (union(tmp.u, tmp.v)) {
                ans += tmp.w;
            } else {
                System.out.println(tmp.u+" "+tmp.v+" "+tmp.w);
            }
        }

        System.out.println(ans);

    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b) return false;
        else root[b] = a;

        return true;

    }

    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
