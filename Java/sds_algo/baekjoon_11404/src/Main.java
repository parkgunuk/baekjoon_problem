import java.util.*;
import java.io.*;

public class Main{
    static final int MAX = Integer.MAX_VALUE;
    static int N, M;
    static int[][] map;
    private static int stoi(String input){return Integer.parseInt(input);}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        M = stoi(br.readLine());
        map = new int[N+1][N+1];

        for(int i = 1 ;i<N+1;++i) {
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }

        for(int i = 0 ; i<M;++i) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            map[a][b] = Math.min(c, map[a][b]);
        }

        floyd();
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=N;++i){
            for(int j = 1; j<=N;++j){
                if(map[i][j] == MAX){
                    sb.append(0);
                    sb.append(" ");
                } else {
                    sb.append(map[i][j]);
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void floyd(){
        for(int i = 1 ; i <= N ; ++i){
            for(int j = 1 ; j <= N ; ++j){
                for(int k = 1 ; k <= N ; ++k){
                    if (map[j][i] == MAX || map[i][k] == MAX) continue;
                    if (map[j][k] > map[j][i] + map[i][k]) map[j][k] = map[j][i] + map[i][k];
                }
            }
        }
    }
}
