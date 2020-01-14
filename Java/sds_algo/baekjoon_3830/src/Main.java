import java.util.*;
import java.io.*;

public class Main {
    static int[] root;
    static long[] weight;
    static long[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            root = new int[100001];
            weight = new long[100001];
            size = new long[100001];

            for (int i = 0; i <= 100000; ++i) root[i] = i;

            if (n == 0 && m == 0) break;
            else {
                for (int i = 0; i < m; ++i) {
                    st = new StringTokenizer(br.readLine());

                    String s = st.nextToken();
                    if (s.equals("!")) {
                        int a = Integer.parseInt(st.nextToken());
                        int b = Integer.parseInt(st.nextToken());
                        long w = Long.parseLong(st.nextToken());

                        union(a, b, w);

                    } else if (s.equals("?")) {
                        int a = Integer.parseInt(st.nextToken());
                        int b = Integer.parseInt(st.nextToken());

                        if (find(a) != find(b)) System.out.println("UNKNOWN");
                        else System.out.println(weight[b] - weight[a]);

                    }
                }
            }
        }
    }

    private static void union(int a, int b, long diff) {
        int na = find(a);
        int nb = find(b);

        if (na == nb) return;
        if (size[na] > size[nb]) {
            int tmp = a;
            a = b;
            b = tmp;

            tmp = na;
            na = nb;
            nb = tmp;

            diff *= -1;
        }

        size[na] += size[nb];
        root[nb] = na;
        weight[nb] += (diff - weight[b] + weight[a]);
    }

    private static int find(int a) {
        if (root[a] == a) return a;
        else {
            int prv = find(root[a]);
            weight[a] += weight[root[a]];
            return root[a] = prv;
        }
    }
}
