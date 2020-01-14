import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int level;

        Node(int idx, int level){
            this.idx = idx;
            this.level = level;
        }

        @Override
        public int compareTo(Node o) {
            return this.level - o.level;
        }
    }

    static int N, M, step = 0, L = 0;
    static int[] euler, depth, index, pow;
    static Node[][] sTable;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i = 1 ; i<=N;++i){
            list[i] = new ArrayList<>();
        }

        for(int i = 1 ; i<N;++i){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        preProcess();

        M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int a = index[Integer.parseInt(st.nextToken())];
            int b = index[Integer.parseInt(st.nextToken())];

            query(Math.min(a, b), Math.max(a, b));
        }

        System.out.println(sb.toString());
    }


    private static void query(int a, int b){
        int idx = 0;
        while (b - a >= (1 << ++idx));
        idx--;
        sb.append(min(sTable[idx][a], sTable[idx][b - pow[idx] + 1]).idx + "\n");

    }

    private static Node min(Node a, Node b) {
        if (b == null) return a;
        return a.level < b.level ? a : b;
    }

    private static void preProcess() {
        euler = new int[N << 1];
        depth = new int[N << 1];
        index = new int[N + 1];
        dfs(1, 1, 0);

        while (step > (1 << ++L));

        sTable = new Node[L + 1][step + 1];
        pow = new int[L];

        createSparse(); //희소행렬로 만들기
        //DP로 만들기
    }

    private static void dfs(int here, int parent, int d) {
        depth[here] = d;
        euler[++step] = here;
        if (index[here] == 0) {
            index[here] = step;
        }

        for (int there : list[here]) {
            if (there != parent) {
                dfs(there, here, d + 1);
                euler[++step] = here;
                if (index[here] == 0) {
                    index[here] = step;
                }
            }
        }
    }

    private static void createSparse() {
        pow[0] = 1;
        for (int i = 1; i < L; i++) {
            pow[i] = pow[i - 1] << 1;
        }

        for (int i = 1; i <= step; i++) {
            sTable[0][i] = new Node(euler[i], depth[euler[i]]);
        }

        for (int i = 1; i <= L; i++) {
            for (int j = 1; pow[i - 1] + j <= step; j++) {
                sTable[i][j] = min(sTable[i - 1][j], sTable[i - 1][j + pow[i - 1]]);
            }
        }
    }

}
