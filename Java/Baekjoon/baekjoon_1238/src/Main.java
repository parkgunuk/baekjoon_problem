import java.util.*;
import java.io.*;
class Main{
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int X = stoi(st.nextToken());

        int[][] map = new int[1001][1001];

        for(int i = 1 ; i<=N;++i) {
            Arrays.fill(map[i], 987654321);
            map[i][i] = 0;
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            map[stoi(st.nextToken())][stoi(st.nextToken())] = stoi(st.nextToken());
        }

        //플로이드 와샬
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++)
                for(int j=1;j<=N;j++){
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
        }

        //왕복거리 최대값 찾기
        int max = 0;
        for(int i=1;i<=N;i++){
            max = Math.max(max, map[i][X]+map[X][i]);
        }

        System.out.println(max);
    }
}