import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class node{
        int r, c;
        private node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int N, min, max, ans;
    static int[][] map, dir = {{0,1},{1,0},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        ans = 1;

        map = new int[N+1][N+1];
        for(int i = 0 ; i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N;++j){
                map[i][j] = stoi(st.nextToken());
                min = Math.min(min,map[i][j]);
                max = Math.max(max,map[i][j]);
            }
        }
        for(int i = min ; i < max ; ++i) bfs(i);

        System.out.println(ans);
    }
    private static void bfs(int rain){
        Queue<node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        int cnt = 0 ;
        for(int r = 0 ; r < N ; ++r){
            for(int c = 0 ; c < N ; ++c){
                if(visited[r][c] || map[r][c] <= rain) continue;

                q.add(new node(r,c));
                while(!q.isEmpty()){
                    node n = q.poll();
                    for(int i = 0 ; i<4;++i){
                        int nr = n.r+dir[i][0];
                        int nc = n.c+dir[i][1];

                        if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                        if(visited[nr][nc] || map[nr][nc] <= rain) continue;

                        q.add(new node(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}