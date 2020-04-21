import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];

        for(int r = 0 ; r<R;++r){
            String[] s = br.readLine().split("");
            for(int c = 0 ; c<C;++c){
                map[r][c] = Integer.parseInt(s[c]);
            }
        }
        int ans = 0;
        for(int r = 1 ; r<R;++r){
            for(int c = 1 ; c<C;++c){
                if(map[r][c] != 0){
                    map[r][c] += Math.min(map[r-1][c], Math.min(map[r][c-1], map[r-1][c-1]));
                }
            }
        }

        for(int r = 0 ; r<R;++r){
            for(int c = 0;c<C;++c){
                ans = ans>map[r][c] ? ans : map[r][c];
            }
        }

        System.out.println(ans*ans);
    }
}
