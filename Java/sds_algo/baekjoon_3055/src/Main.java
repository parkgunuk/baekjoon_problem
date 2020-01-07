import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> waterQueue;
    static Queue<Node> hedgehogQueue;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int R,C;

    static class Node{
        int r;
        int c;
        int time;

        Node(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        String buff = sc.nextLine();
        waterQueue = new LinkedList<>();
        hedgehogQueue = new LinkedList<>();
        map = new char[R][];
        visited = new boolean[R][C];
        for(int r = 0; r<R;++r){
            map[r] = sc.nextLine().toCharArray();
        }

        for(int r = 0; r<R;++r){
            for(int c = 0 ;c<C;++c){
                if(map[r][c] == 'S'){
                    hedgehogQueue.add(new Node(r,c,0));
                    visited[r][c] = true;
                }
                if(map[r][c] == '*'){
                    waterQueue.add(new Node(r,c,0));
                    visited[r][c] = true;
                }
            }
        }
        int ans = 0;
        boolean flag = true;
        while(flag){
            int waterQueueSize = waterQueue.size();
            int hedgehogQueueSize = hedgehogQueue.size();

            if(waterQueueSize == 0 && hedgehogQueueSize == 0) break;

            while(waterQueueSize-->0) {
                Node willWater = waterQueue.poll();
                for (int i = 0; i < 4; ++i) {
                    int nr = willWater.r + dir[i][0];
                    int nc = willWater.c + dir[i][1];

                    if(nr<0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] == 'X' || map[nr][nc] == '*' || map[nr][nc] == 'D') continue;

                    waterQueue.add(new Node(nr, nc,willWater.time+1));
                    map[nr][nc] = '*';
                }
            }

            while(hedgehogQueueSize-->0) {
                Node willHedgehog = hedgehogQueue.poll();
                if(map[willHedgehog.r][willHedgehog.c] == 'D'){
                    ans = willHedgehog.time;
                    flag = false;
                    break;
                }

                for (int i = 0; i < 4; ++i) {
                    int nr = willHedgehog.r + dir[i][0];
                    int nc = willHedgehog.c + dir[i][1];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if(map[nr][nc] == 'X' || map[nr][nc] == '*' || visited[nr][nc]) continue;

                    hedgehogQueue.add(new Node(nr,nc,willHedgehog.time+1));
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println(ans>0?ans:"KAKTUS");
    }
}
