import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static class Node{
        int r, c, isDestory;
        Node(int r, int c, int isDestory){
            this.r = r;
            this.c = c;
            this.isDestory = isDestory;
        }
    }

    static int N,M;
    static int[][] map;
    static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];

        for(int i = 1; i <=N ; ++i){
            String[] s = br.readLine().split("");
            for(int j = 1; j<=M;++j){
                map[i][j] = stoi(s[j-1]);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 0));
        visited[1][1][0] = true;
        visited[1][1][1] = true;

        boolean flag = false;
        int step = 0;

        while(!q.isEmpty() && !flag) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node u = q.poll();

                if (u.r == N && u.c == M) {
                    flag = true;
                    break;
                }

                // 탐색
                for (int j = 0; j < 4; j++) {

                    int nextRow = u.r + dir[j][0];
                    int nextCol = u.c + dir[j][1];

                    if (nextRow <= 0 || nextRow > N || nextCol <= 0 || nextCol > M) continue;

                    // 벽
                    if (map[nextRow][nextCol] == 1) {
                        if (u.isDestory < 1 && !visited[nextRow][nextCol][1]) {
                            q.add(new Node(nextRow, nextCol, 1));
                            visited[nextRow][nextCol][1] = true;
                        }
                    }
                    // 빈칸
                    else {
                        if (!visited[nextRow][nextCol][u.isDestory]) {
                            q.add(new Node(nextRow, nextCol, u.isDestory));
                            visited[nextRow][nextCol][u.isDestory] = true;
                        }
                    }
                }
            }
        }
        System.out.println(flag ? step : -1);
    }
}
