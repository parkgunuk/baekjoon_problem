import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int r, c, cnt;
        private Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }

    private static int H, W, ph1, pw1, ph2, pw2;
    private static char[][] map;
    private static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static int[][] door;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = stoi(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            H = stoi(st.nextToken());
            W = stoi(st.nextToken());

            map = new char[H+2][W+2];
            door = new int[H+2][W+2];

            boolean flag = false;
            for(int h = 1 ; h <= H ; ++h){
                char[] tmp = br.readLine().toCharArray();
                for(int w = 1 ; w <= W ; ++w){
                    map[h][w] = tmp[w-1];
                    if(map[h][w] == '$'){
                        if(!flag) {
                            ph2 = h;
                            pw2 = w;
                            flag = true;
                        } else {
                            ph1 = h;
                            pw1 = w;
                        }
                    }
                }
            }

            for (int i = 0; i <= W + 1; i++) {
                map[0][i] = '.';
                map[H + 1][i] = '.';
            }

            for (int i = 0; i <= H + 1; i++) {
                map[i][0] = '.';
                map[i][W + 1] = '.';
            }

            int res = 0;

            if(findPersonFirst()) System.out.println(0);
            else {
                for(int i = 0 ; i < 3 ; ++i) {
                    BFS(i);
//                    print();
//                    System.out.println();
//                    System.out.println("===================================");
                }

                res = getSum();
//                print();
                System.out.println(res);
            }

        }
    }
    private static int getSum(){
        int min = Integer.MAX_VALUE;

        for(int i = 1 ; i < H+1 ; ++i){
            for(int j = 1 ; j < W+1 ; ++j){
                if(map[i][j] == '#') min = Math.min(min, door[i][j]);
            }
        }
        return min-2;
    }
    private static boolean findPersonFirst(){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[H+2][W+2];
        q.add(new Node(0,0,0));
        visited[0][0] = true;

        int cnt = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if (nr < 0 || nr >= H + 2 || nc < 0 || nc >= W + 2) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == '*' || map[nr][nc] == '#') continue;

                visited[nr][nc] = true;
                if (map[nr][nc] == '$') cnt++;
                q.add(new Node(nr, nc, 0));
            }
        }
        if(cnt == 2) return true;
        else return false;

    }

    private static void BFS(int i){
        PriorityQueue<Node> q = new PriorityQueue<>();
        visited = new boolean[H+2][W+2];

        if(i == 0) {
            q.add(new Node(0,0, 0));
            visited[0][0] = true;
        } else if (i == 1){
            q.add(new Node(ph1, pw1, 0));
            visited[ph1][pw1] = true;
        } else if(i == 2){
            q.add(new Node(ph2, pw2, 0));
            visited[ph2][pw2] = true;
        }

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int j = 0 ; j < 4 ; ++j){
                int nr = n.r + dir[j][0];
                int nc = n.c + dir[j][1];

                if(nr < 0 || nr >= H+2 || nc < 0 || nc >= W+2) continue;
                if(visited[nr][nc] || map[nr][nc] == '*') continue;

                visited[nr][nc] = true;

                // visited[nr][nc] == false 일때
                if(map[nr][nc] == '#') {
//                    if(i != 0 && door[0][nr][nc] == 0)continue;
                    door[nr][nc] += n.cnt + 1;
                    q.add(new Node(nr, nc, n.cnt + 1));
                } else {
                    q.add(new Node(nr, nc, n.cnt));
                }

            }
        }
    }

    private static void print(){
        System.out.println();
        System.out.println("print");
        for(int i = 0 ; i < H+2 ; ++i){
            for(int j = 0 ; j < W+2 ; ++j){
                System.out.print(door[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
