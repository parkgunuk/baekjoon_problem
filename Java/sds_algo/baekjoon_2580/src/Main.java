import java.util.*;

public class Main {
    static int[][] map;
    static List<int[]> list;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        list = new ArrayList<>();

        for(int r = 0 ; r < 9 ; ++r) {
            for (int c = 0; c < 9; ++c) {
                map[r][c] = sc.nextInt();

                if (map[r][c] == 0){
                    int[] tmp = {r,c};
                    list.add(tmp);
                }
            }
        }
        backtracking(0,0);
        System.out.println(sb.toString());

    }
    private static void backtracking(int idx, int cnt){
        if(flag) return;

        if(cnt==list.size()) {
            flag = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
            return;

        } else {
            int[] tmp = list.get(idx);
            for (int j = 1; j < 10; ++j) {
                if(!check(tmp[0],tmp[1],j))continue;
                else {
                    map[tmp[0]][tmp[1]] = j;
                    backtracking(idx + 1, cnt + 1);
                    if (flag) return;
                    map[tmp[0]][tmp[1]] = 0;
                }
            }
        }
    }


    private static boolean check(int x, int y, int v) {
        // 가로, 세로
        for (int i = 0; i < 9; i++) {
            if(map[i][y] == v || map[x][i] == v) {
                return false;
            }
        }
        // 3x3 격자 내부
        for (int i = (x/3)*3; i < (x/3)*3 + 3; i++) {
            for (int j = (y/3)*3; j < (y/3)*3 +3; j++) {
                if(map[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}
