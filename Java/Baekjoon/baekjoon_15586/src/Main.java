import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int u;
        int v;
        int usado;

        private Node(int u, int v, int usado){
            this.u = u;
            this.v = v;
            this.usado = usado;
        }

        @Override
        public int compareTo(Node o) {
            return o.usado - this.usado;
        }
    }

    private static class Query implements Comparable<Query> {
        int idx, k, target;

        private Query(int idx, int k, int target) {
            this.idx = idx;
            this.k = k;
            this.target = target;
        }

        @Override
        public int compareTo(Query o) {
            return o.k - this.k;
        }
    }

    private static int N, Q;
    private static ArrayList<Node> list;
    private static Query[] query;
    private static int[] root, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());
        list = new ArrayList<>();
        query = new Query[Q];
        root = new int[N + 1];
        cnt = new int[N + 1];

        Arrays.fill(root, -1);
        Arrays.fill(cnt, 1);

        for (int i = 0; i < N-1; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            list.add(new Node(u-1, v-1, w));
        }
        Collections.sort(list);

        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine());
            int k = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            query[i] = new Query(i, k, v-1);
        }

        Arrays.sort(query);

        int[] res = new int[Q];
        int idx = 0;
        for (Query q : query) {
            while (idx < list.size() && list.get(idx).usado >= q.k) {
                union(list.get(idx).u, list.get(idx).v);
                idx++;
            }

            res[q.idx] = cnt[find(q.target)] - 1;
        }
        for (int n : res) {
            System.out.println(n);
        }
    }


    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return false;
        cnt[b] += cnt[a];
        root[a] = b;

        return true;
    }

    private static int find(int a){
        if(root[a] == -1) return a;
        return root[a] = find(root[a]);
    }
}
