import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    private static int N, M, res = Integer.MIN_VALUE;
    private static int[][] map, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; ++j){
                map[i][j] = stoi(st.nextToken());
            }
        }

        solution(0,0);
        System.out.println(res);
    }
    private static void solution(int cnt, int limit){
        if(cnt == 2){
            visited = new boolean[N][M];
            int dead = 0;
            for(int r = 0 ; r < N ; ++r) {
                for(int c = 0 ; c < M ; ++c) {
                    if(map[r][c] == 2 && !visited[r][c]) {
                        dead += count(r, c);
                    }
                }
            }

            res = Math.max(res, dead);
            return;
        }

        for(int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < M ; ++c) {
                // 이전 셀에 대한 값 보다 큰 셀 부터 시작한다.
                if(r * N + c < limit) continue;
                if(map[r][c] == 0) {
                    map[r][c] = 1;
                    // r * 100 + c를 다음 limit로 넘긴다.
                    solution(cnt + 1, r * N +c);
                    map[r][c] = 0;
                }
            }
        }
    }

    private static int count(int r, int c){
        Queue<int[]>q = new LinkedList<>();
        int cnt = 1;
        boolean flag = true;

        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0 ; i < 4 ; ++i) {
                int nr = now[0] + dir[i][0];
                int nc = now[1] + dir[i][1];
                if(nr >= N || nr < 0 || nc >= M || nc < 0 || visited[nr][nc]) continue;

                if(map[nr][nc] == 0) flag = false;
                else if(map[nr][nc] == 2) {
                    q.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }

        if(flag) {
            return cnt;
        }
        return 0;
    }
}