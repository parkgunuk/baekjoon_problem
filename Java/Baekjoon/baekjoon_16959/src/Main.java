import javax.swing.*;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, sr, sc;
    private static int[][] map;
    private static final int[][] Knight = {{-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}};
    private static final int[][] Bishop = {{-1,-1}, {1,1}, {-1,1}, {1,-1}};
    private static final int[][] Rook = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int[][][][] dist;

    private static class Node{
        int chess, r, c, number;
        private Node(int chess, int r, int c, int number){
            this.chess = chess;
            this.r = r;
            this.c = c;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        map = new int[N][N];
        dist = new int[3][N][N][N*N];

        for(int i = 0 ; i < 3; ++i){
            for(int j = 0 ; j < N ; ++j){
                for(int k = 0 ; k < N ; ++k)
                    Arrays.fill(dist[i][j][k], -1);
            }
        }

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j){
                map[i][j] = stoi(st.nextToken())-1;
                if(map[i][j] == 0) {
                    sr = i; sc = j;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            dist[i][sr][sc][0] = 0;
            q.add(new Node(i, sr, sc, 0));
        }

        int ans = -1;
        while(!q.isEmpty()){
            Node n = q.poll();

            if (n.number == N*N - 1) {
                if (ans == -1 || ans > dist[n.chess][n.r][n.c][n.number]) {
                    ans = dist[n.chess][n.r][n.c][n.number];
                }
                continue;
            }

            for (int k = 0; k < 3; k++) {
                if (n.chess == k) continue;
                if (dist[k][n.r][n.c][n.number] == -1) {
                    dist[k][n.r][n.c][n.number] = dist[n.chess][n.r][n.c][n.number] + 1;
                    q.add(new Node(k, n.r, n.c, n.number));
                }
            }

            if (n.chess == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = n.r + Knight[i][0];
                    int nc = n.c + Knight[i][1];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                    int num = n.number;
                    if (map[nr][nc] == num + 1) num++;

                    if (dist[n.chess][nr][nc][num] == -1) {
                        dist[n.chess][nr][nc][num] = dist[n.chess][n.r][n.c][n.number] + 1;
                        q.add(new Node(n.chess, nr, nc, num));
                    }
                }
            } else if (n.chess == 1) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; ; j++) {
                        int nr = n.r + Rook[i][0] * j;
                        int nc = n.c + Rook[i][1] * j;
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
                        int num = n.number;
                        if (map[nr][nc] == num + 1) num++;

                        if (dist[n.chess][nr][nc][num] == -1) {
                            dist[n.chess][nr][nc][num] = dist[n.chess][n.r][n.c][n.number] + 1;
                            q.add(new Node(n.chess, nr, nc, num));
                        }
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; ; j++) {
                        int nr = n.r + Bishop[i][0] * j;
                        int nc = n.c + Bishop[i][1] * j;
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) break;
                        int num = n.number;
                        if (map[nr][nc] == num + 1) num++;

                        if (dist[n.chess][nr][nc][num] == -1) {
                            dist[n.chess][nr][nc][num] = dist[n.chess][n.r][n.c][n.number] + 1;
                            q.add(new Node(n.chess, nr, nc, num));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
