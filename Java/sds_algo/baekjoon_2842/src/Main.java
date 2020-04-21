import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static char[][] map;
    static int[][] height, check;
    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    static int N, postR, postC, cnt;
    static ArrayList<Integer> list;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        init();

        for(int r = 1 ;r<=N;++r) {
            char[] tmp = br.readLine().toCharArray();
            for(int c = 1 ; c<=N;++c){
                map[r][c] = tmp[c-1];
                if(map[r][c] == 'P'){
                    postR = r; postC = c;
                }
                if(map[r][c] == 'K') cnt++;
            }
        }
        for(int r = 1 ; r<=N;++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 1 ; c<=N;++c){
                height[r][c] = stoi(st.nextToken());
                set.add(height[r][c]);
            }
        }

        list.addAll(set);
        Collections.sort(list);

        int pp =0, ans = INF;
        for(int p = 0 ; p<list.size(); ++p){
            while(true){
                if(pp>=list.size()) break;

                check = new int[55][55];
                if (DFS(postR, postC, list.get(pp), list.get(p)) != cnt) break;
                ans = Math.min(ans, list.get(p)-list.get(pp++));

            }
        }
        System.out.println(ans);
    }

    private static int DFS(int r, int c, int min, int max){
        if(r<1 || r>N || c<1 || c >N) return 0;
        if(check[r][c] > 0 || height[r][c] < min || height[r][c] > max) return 0;

        check[r][c] = 1;
        int res = 0;
        if(map[r][c] == 'K') res++;

        for(int i = 0 ; i<8;++i){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            res += DFS(nr,nc,min,max);
        }
        return res;
    }

    private static void init(){
        map = new char[55][55];
        height = new int[55][55];
        list = new ArrayList<>();
        postR = 0;
        postC = 0;
    }
}
