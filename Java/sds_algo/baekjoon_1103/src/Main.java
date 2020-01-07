import java.util.*;

public class Main {
    static char[][] map;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int ans;
    static int R,C;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        String buff = sc.nextLine();

        map = new char[R][];
        visited = new boolean[R][C];
        ans = 0;

        for(int r = 0; r< R; ++r){
            map[r] = sc.nextLine().toCharArray();
        }
        visited[0][0]=true;
        dfs(0,0,1);
        System.out.println(ans);
    }
    private static void dfs(int r, int c, int cnt){
        if(map[r][c] == 'H') {
            ans = ans > cnt ? ans : cnt;
            return;
        }
//        if()
        else {
            for (int i = 0; i < 4; ++i) {
                int nr = r + dir[i][0] * (map[r][c] - '0');
                int nc = c + dir[i][1] * (map[r][c] - '0');

                if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                    ans = ans>cnt?ans:cnt;
                    continue;
                }
                if(visited[nr][nc]) {
                    ans = -1;
                    return;
                }

                visited[nr][nc]=true;
                dfs(nr,nc,cnt+1);
            }
        }
    }
}
