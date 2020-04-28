import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int r, c;
        private Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static final int[][] DIR = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

    private static int R, C;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new int[R][C];
        int[][] minDist = new int[R][C];
        Queue<Node> q = new LinkedList<>();


        for(int i = 0; i < R; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; ++j){
                map[i][j] = stoi(st.nextToken());
                minDist[i][j] = Integer.MAX_VALUE;
                if(map[i][j]==1) {
                    q.add(new Node(i,j));
                    minDist[i][j]=0;
                }
            }
        }

        int res = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i = 0 ; i < 8 ; ++i) {
                int nr = cur.r + DIR[i][0];
                int nc = cur.c + DIR[i][1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                if (minDist[nr][nc] > minDist[cur.r][cur.c] + 1) {
                    minDist[nr][nc] = minDist[cur.r][cur.c] + 1;
                    q.add(new Node(nr, nc));
                    res = Math.max(minDist[nr][nc], res);
                }
            }
        }

        System.out.println(res);
    }
}