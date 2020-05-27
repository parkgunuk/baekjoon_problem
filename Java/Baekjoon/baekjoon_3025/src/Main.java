import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    private static int R, C;
    private static char[][] map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new char[R][C];
        for(int i = 0 ; i < R ; ++i){
            map[i] = br.readLine().toCharArray();
        }

        int N = stoi(br.readLine());

        for(int i = 0 ; i < N ; ++i){
            int c = stoi(br.readLine()) - 1;
            process(0, c);
        }

        print();
        System.out.println(sb.toString());
    }
    private static void process(int r, int c){
        int i = r;
        for(i = r ; i < R ; ++i){
            if(map[i][c] == '.') continue;
            if(map[i][c] == 'X') {
                map[i-1][c] = 'o';
                return;
            }

            if(map[i][c] == 'o'){
                if(c-1 >= 0 && map[i][c-1] == '.') {
                    process(i+1, c-1);
                    return;
                }
                else if(c+1 < C && map[i][c+1] == '.') {
                    process(i + 1, c + 1);
                    return;
                }

                map[i-1][c] = 'o';
            }

        }
        if(i == R ) map[i-1][c] = 'o';
    }

    private static void print(){
        for(int i = 0 ; i < R ; ++i){
            for(int j = 0 ; j < C ; ++j) sb.append(map[i][j] );
            sb.append("\n");
        }
    }
}
