import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N, M;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = stoi(br.readLine());

        map = new int[N+1][N+1];

        String[] s;
        for(int i = 0 ; i < N; ++i){
            s = br.readLine().split("");
            for(int j = 0 ; j<N;++j){
                map[i][j] = stoi(s[j]);
            }
        }
        rec(0, 0, N);
        System.out.println(sb.toString());
    }
    private static boolean check(int row, int col, int n){
        int tmp = map[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (tmp != map[i][j]) {
                    return false;
                }
            }
        }
        M = tmp;
        return true;
    }
    private static void rec(int row, int col, int n){
        if(check(row, col, n)) sb.append(M);
        else {
            sb.append("(");
            int s = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    rec(row + s * i, col + s * j, s);
                }
            }
            sb.append(")");
        }
    }
}
