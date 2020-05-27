import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Plant {
        int x, y, z, idx;

        private Plant(int x, int y, int z, int idx){
            this.x = x;
            this.y = y;
            this.z = z;
            this.idx = idx;
        }
    }

    private static class Node implements Comparable<Node>{
        int u, v, w;
        private Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    private static int N;
    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        Plant[] plants = new Plant[N];
        root = new int[N];
        Arrays.fill(root, -1);

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            plants[i] = new Plant(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), i);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Comparator<Plant> cpx = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.x - o2.x;
            }
        };

        Arrays.sort(plants, cpx);

        for (int i = 1; i < N; i++) pq.add(new Node(plants[i - 1].idx, plants[i].idx, Math.abs(plants[i].x - plants[i - 1].x)));

        Comparator<Plant> cpy = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.y - o2.y;
            }
        };

        Arrays.sort(plants, cpy);

        for (int i = 1; i < N; i++) pq.add(new Node(plants[i - 1].idx, plants[i].idx, Math.abs(plants[i].y - plants[i - 1].y)));

        Comparator<Plant> cpz = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                return o1.z - o2.z;
            }
        };
        Arrays.sort(plants, cpz);

        for (int i = 1; i < N; i++) pq.add(new Node(plants[i - 1].idx, plants[i].idx, Math.abs(plants[i].z - plants[i - 1].z)));

        int idx = 0;
        int ans = 0;
        while(!pq.isEmpty() && idx < N){
            Node n = pq.poll();

            if(!union(n.u, n.v)){
                ans += n.w;
                idx++;
            }
        }
        System.out.println(ans);

    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else {
            root[b] = a;
            return false;
        }
    }

    private static int find(int a){
        if(root[a] < 0) return a;
        return root[a] = find(root[a]);
    }
}
