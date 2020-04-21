import java.util.*;
import java.io.*;

public class Main {
    static int count = 1;

    static int[] discovered;
    static ArrayList<Node> isCutEdge;
    static ArrayList<Integer>[] list;

    static class Node implements Comparable<Node>{
        int u,v;
        Node(int u, int v){
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.u-o.u;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];

        discovered = new int[N];
        isCutEdge = new ArrayList<>();

        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < N; i++) {
            if (discovered[i] == 0) {
                dfs(i, 0);
            }
        }
        Collections.sort(isCutEdge);
        System.out.println(isCutEdge.size());
        for(Node n : isCutEdge) System.out.println(n.u+" "+n.v);

    }
    /*
        E가 단절 선 이라면, low[A] = A의 자신..
     */
    private static int dfs(int edge, int root) {

        discovered[edge] = ++count;
        int ret = discovered[edge];

        for (int i : list[edge]) {
            if(i == root) continue;
            if (discovered[i] == 0) {
                int low = dfs(i, edge);

                if (low > discovered[edge]) isCutEdge.add(new Node(Math.min(edge, i), Math.max(edge, i)));

                ret = Math.min(ret, low);

            } else ret = Math.min(ret, discovered[i]);

        }
        return ret;
    }
}
