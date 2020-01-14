import java.util.*;
import java.io.*;
public class Main {
    static int[] root;

    static class Node implements Comparable<Node>{
        int a;
        int b;
        int val;

        public Node(int a, int b, int val){
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        root = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i  = 0 ; i<N+1;++i){
            root[i] = i;
        }
        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Node(a,b,c));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (union(node.a,node.b)) ans += node.val;
        }
        System.out.println(ans);
    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        else root[b] = a;
        return true;
    }

    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
