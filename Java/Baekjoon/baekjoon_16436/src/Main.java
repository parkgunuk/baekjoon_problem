import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static final int MAX = 2501;

    private static int W, H, K;
    private static int[][] first, second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = stoi(st.nextToken());
        H = stoi(st.nextToken());
        K = stoi(st.nextToken());

        first = new int[H+2][W+2];
        second = new int[Math.max(W, H) + 2 + MAX][Math.max(W, H) + 2 + MAX];

        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int cmd = stoi(st.nextToken());

            if (cmd == 1) {
                int x1 = stoi(st.nextToken()) + 1;
                int y1 = stoi(st.nextToken()) + 1;
                int x2 = stoi(st.nextToken()) + 2;
                int y2 = stoi(st.nextToken()) + 2;
                update(y1, x1, y2, x2, first);
            }
            else if (cmd == 2) {
                int x = stoi(st.nextToken()) + 1;
                int y = stoi(st.nextToken()) + 1;
                int r = stoi(st.nextToken());
                int x1 = (y - r) - x + MAX;
                int y1 = (y - r) + x;
                int x2 = (y + r) - x + MAX + 1;
                int y2 = (y + r) + x + 1;
                update(y1, x1, y2, x2, second);
            }
        }
        for (int r = 1; r <= H; ++r) {
            for (int c = 1; c <= W; ++c) {
                int sum = sum(r, c, first) + sum(r + c, r - c + MAX, second);
                bw.write((sum % 2 == 1) ? '#' : '.');
            }
            bw.write('\n');
        }
        bw.close();
    }

    private static void update(int y1, int x1, int y2, int x2, int[][] bit) {
        update(y1, x1, 1, bit);
        update(y2, x2, 1, bit);
        update(y1, x2, -1, bit);
        update(y2, x1, -1, bit);
    }

    private static void update(int y, int x, int d, int[][] bit) {
        for (int i = y; i < bit.length; i += i & -i)
            for (int j = x; j < bit[i].length; j += j & -j)
                bit[i][j] += d;
    }

    private static int sum(int y, int x, int[][] bit) {
        int ret = 0;

        for (int i = y; i > 0; i -= i & -i)
            for (int j = x; j > 0; j -= j & -j)
                ret += bit[i][j];

        return ret;
    }
}
