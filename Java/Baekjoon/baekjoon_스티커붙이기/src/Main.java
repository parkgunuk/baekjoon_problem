import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, M, K, r, c;
    private static int[][] notebook, sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = stoi(br.readLine());
//        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = stoi(st.nextToken());
            M = stoi(st.nextToken());
            K = stoi(st.nextToken());

            notebook = new int[N+1][M+1];

            for (int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine());
                r = stoi(st.nextToken());
                c = stoi(st.nextToken());

                sticker = new int[Math.max(r,c)][Math.max(r,c)];
                for (int j = 0; j < r; ++j) {
                    st = new StringTokenizer(br.readLine());
                    for (int k = 0; k < c; ++k) {
                        sticker[j][k] = stoi(st.nextToken());
                    }
                }

                for (int cnt = 0; cnt < 4; ++cnt) {
                    boolean flag = false;
                    for (int x = 0; x <= N - r; x++) {
                        if (flag) break;
                        for (int y = 0; y <= M - c; y++) {
                            if (isPossible(x, y)) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag) break;
                    if (cnt != 3) rotate();
                }
            }
            int res = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (notebook[i][j] != 0) res++;
                }
            }
            System.out.println(res);
//            br.readLine();
//        }
    }

    private static void rotate(){
        int[][] tmp = new int[r][c];
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                tmp[i][j] = sticker[i][j];

        for(int i = 0; i < c; i++)
            for(int j = 0; j < r; j++)
                sticker[i][j] = tmp[r-1-j][i];

        int t = r;
        r = c;
        c = t;
    }

    private static boolean isPossible(int x, int y){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(notebook[x+i][y+j] == 1 && sticker[i][j] == 1) return false;
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(sticker[i][j] == 1)
                    notebook[x+i][y+j] = 1;
            }
        }

        return true;
    }
}
