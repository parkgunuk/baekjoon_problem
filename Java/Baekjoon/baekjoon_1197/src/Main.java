import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int V,E;
    static int[] root;
    static class Node implements Comparable<Node>{
        int s, e, w;
        Node(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        root = new int[V+1];
        for(int i = 0 ; i<V;++i) root[i] = i;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0 ; i<E;++i) {
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            pq.add(new Node(s, e, w));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (isUnion(node.s,node.e)) ans += node.w;
        }
        System.out.println(ans);
    }

    private static boolean isUnion(int a, int b){
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
