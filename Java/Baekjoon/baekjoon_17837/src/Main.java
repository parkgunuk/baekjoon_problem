import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }


    private static class Node {
        int i, r, c, d;

        private Node(int i, int r, int c, int d) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static int N, K;
    private static int[][] map, dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static ArrayList<Integer>[][] piece;
    private static Node[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[13][13];
        piece = new ArrayList[13][13];
        list = new Node[12];

        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; ++j) {
                map[i][j] = stoi(st.nextToken());
                piece[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= K; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int d = stoi(st.nextToken());

            piece[r][c].add(i);
            list[i] = new Node(i, r, c, d-1);
        }

        for (int t = 1; t <= 1000; ++t) {
            for (int i = 1; i <= K; ++i) {
                Node n = list[i];

                int r = n.r;
                int c = n.c;

                int nr = r + dir[n.d][0];
                int nc = c + dir[n.d][1];

                // 파란색 이거나 경로를 넘어갈때
                if (nr <= 0 || nr > N || nc <= 0 || nc > N || map[nr][nc] == 2) {
                    changeDirection(n);

                    nr = r + dir[n.d][0];
                    nc = c + dir[n.d][1];
                }

                if(nr <= N && nr >= 1 && nc <= N && nc >= 1 && map[nr][nc] != 2) {

                    int h = piece[r][c].indexOf(n.i);
                    int size = piece[r][c].size();

                    if (map[nr][nc] == 0) {
                        for (int j = h; j < size; ++j) {
                            int ii = piece[r][c].get(j);
                            updateList(ii, nr, nc);
                            piece[nr][nc].add(ii);
                        }
                    } else if (map[nr][nc] == 1) {
                        for (int j = size - 1; j >= h; --j) {
                            int ii = piece[r][c].get(j);
                            updateList(ii, nr, nc);
                            piece[nr][nc].add(ii);
                        }
                    }
                    for (int j = size - 1; j >= h; --j) piece[r][c].remove(j);

                    if (piece[nr][nc].size() >= 4) {
                        System.out.println(t);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static void changeDirection(Node n) {
        if(n.d % 2 == 0) {
            updateList(n.i, n.r, n.c, n.d+1);
        } else {
            updateList(n.i, n.r, n.c, n.d-1);
        }
    }

    private static void updateList(int idx, int nr, int nc, int nd) {
        list[idx].r = nr;
        list[idx].c = nc;
        list[idx].d = nd;
    }

    private static void updateList(int idx, int nr, int nc) {
        list[idx].r = nr;
        list[idx].c = nc;
    }
}