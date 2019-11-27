import java.util.*;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        root = new int[N+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        int ans = 0;

        for(int i = 0; i<=N;++i) root[i] = i;

        for(int i = 0; i<M;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int val = sc.nextInt();

            Node tmp = new Node(a,b,val);

            q.add(tmp);
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            if (union(node.a, node.b)){
                ans += node.val;
            }
        }
        System.out.println(ans);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return false;
        else {
            root[y] = x;
            return true;
        }
    }

    public static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);

    }
}
