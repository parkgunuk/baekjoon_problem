import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N;
    private static int[][] map, label;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        map = new int[N+1][N+1];
        label = new int[N+1][N+1];

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int res = Integer.MAX_VALUE ;

        for(int r = 0 ; r < N ; ++r){
            for(int c = 1; c < N ; ++c){
                for(int d1 = 1 ; d1 < c ; ++d1){
                    for(int d2 = 1 ; d2 < N - c ; ++d2){
                        if(isPossible(r, c, d1, d2)){
                           res = Math.min(res, cal(r, c, d1, d2));
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
    private static int cal(int r, int c, int d1, int d2){
        for(int i = 0 ; i < N ; ++i) Arrays.fill(label[i], 5);

        int[] people = new int[6];
        // 1번 선거구
        int nr = r + d1;
        int nc = c - d1;

        int left = 0;
        for(int i = 0 ; i < nr ; ++i){
            if(i >= r) left++;
            for (int j = 0; j <=  c - left; j++) label[i][j] = 1;
        }

        //2번 선거구
        left = 0;
        nr = r + d2;
        for (int i = 0; i <= nr ; ++i) {
            if (i > r) left++;
            for (int j = c + 1 + left; j < N; ++j) label[i][j] = 2;

        }

        //3번 선거구
        left = 0;
        nr = r + d1 + d2;
        nc = c - d1 + d2;
        for (int i = N - 1; i >= r + d1; --i) {
            if (i < nr) left++;
            for (int j = 0; j < nc - left; j++) label[i][j] = 3;
        }

        //4번 선거구
        left = 0;
        for (int i = N - 1; i > r + d2 ; --i) {
            if (i <= nr) left++;
            for (int j = nc + left; j < N; j++) label[i][j] = 4;
        }

        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < N ; ++j){
                people[label[i][j]] += map[i][j];
            }
        }

        Arrays.sort(people);

        return people[5] - people[1];
    }

    private static boolean isPossible(int r, int c, int d1, int d2){

        if (r + d1 >= N || c - d1 < 0 || r + d2 >= N || c + d2 >= N) return false;
        if (r + d1 + d2 >= N || c - d1 + d2 >= N || c + d2 - d1 < 0) return false;

        return true;
    }

    private static void print(){
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < N ; ++j){
                System.out.print(label[i][j] + " ");
            }
            System.out.println();
        }
    }
}