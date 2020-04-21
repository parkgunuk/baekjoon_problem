import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, Q, size = 1;
    private static int[] root, next, num, result;
    private static boolean[] iscycle, cut, type;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        root = new int[N+1];

        next = new int[N + 1];
        cut = new boolean[N + 1];
        iscycle = new boolean[N + 1];
        for (int i = 1; i <= N; i++) root[i] = -1;

        st = new StringTokenizer(br.readLine());

        int idx = 1;
        while(st.hasMoreTokens()) next[idx++] = stoi(st.nextToken());


        Q = stoi(br.readLine());
        type = new boolean[Q + 1];
        num = new int[Q + 1];
        result = new int[Q + 1];

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < Q ; ++i){
            st = new StringTokenizer(br.readLine());
            int cmd = stoi(st.nextToken());
            int value = stoi(st.nextToken());
            add(cmd == 1, value);
        }

        for (int i = 1; i <= N; i++) {
            if (!cut[i]) {
                union(i, next[i]);
            }
        }

//		print();
        for (int i = Q; i >= 1; i--) {
//			System.out.println(i + " 일떄");
            if (type[i]) { // 1
                int temp = find(num[i]);
                result[i] = iscycle[temp] ? -1 : temp;
            } else { // 2
//				System.out.println(num[i] + " " + next[num[i]]);
                union(num[i], next[num[i]]);
            }
        }

        for (int i = 1; i <= Q; i++) {
            if (result[i] == 0) continue;

            sb.append((result[i] == -1 ? "CIKLUS" : result[i]) + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void add(boolean t, int n) {
        if (!t) {
            cut[n] = true;
        }
        type[size] = t;
        num[size++] = n;
    }

    private static void union(int a, int b){
        if (a == 0 || b == 0) return;

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) root[aRoot] = bRoot;
        else iscycle[bRoot] = true;
    }

    private static int find(int a){
        if(root[a] < 0) return a;
        return root[a] = find(root[a]);
    }
}
