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

    private static int N, res = Integer.MAX_VALUE;
    private static int[][] map, area, boundary, dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        map = new int[N][N];
        area = new int[N][N];
        boundary = new int[N][N];

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int a = 1;
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < N ; ++j){
                if(map[i][j] == 1 && area[i][j] == 0){
                    mapAreaSet(i, j, a);
                    a++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (boundary[i][j] <1) continue;

                res = Math.min(res, makeBridge(i, j, boundary[i][j]));
            }
        }

        System.out.println(res);
    }

    private static int makeBridge(int r, int c, int cur){
        Queue<Node> q = new LinkedList<>();
        int[][] check = new int[N][N];
        int val = 0;

        q.add(new Node(r,c));
        check[r][c] = 1;

        while(!q.isEmpty()){

            int qSize = q.size();
            val++;

            for (int k = 0 ; k < qSize; ++k) {
                Node n = q.poll();

                for (int i = 0; i < 4; ++i) {
                    int nr = n.r + dir[i][0];
                    int nc = n.c + dir[i][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (check[nr][nc] != 0 || boundary[nr][nc] == -1 || boundary[nr][nc] == cur) continue;

                    if (boundary[nr][nc] > 0 && boundary[nr][nc] != cur) return val - 1;

                    if (boundary[nr][nc] == 0) {
                        q.add(new Node(nr, nc));
                        check[nr][nc] = val;
                    }
                }
            }
        }

        return val;
    }

    private static void mapAreaSet(int r, int c, int a){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        area[r][c] = a;
        boundary[r][c] = -1;
        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i = 0 ; i < 4 ; ++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || area[nr][nc] != 0) continue;
                if(map[nr][nc] == 1) {
                    area[nr][nc] = a;
                    boundary[nr][nc] = -1;
                    q.add(new Node(nr, nc));
                }
                if(map[nr][nc] == 0) boundary[n.r][n.c] = a;
            }
        }
    }
}