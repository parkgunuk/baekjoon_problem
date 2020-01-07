import java.util.*;

public class Main {
    static char[][] map;
    static int[][] height;
    static boolean[][] isChecked;
    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        map = new char[N][];
        height = new int[N][N];
        isChecked = new boolean[N][N];

        for(int i = 0 ;i<N;++i) Arrays.fill(isChecked, true);
        for(int i = 0 ;i<N;++i) map[i] = sc.nextLine().toCharArray();
        for(int r = 0 ; r<N;++r){
            for(int c = 0 ; c<N;++c){
                height[r][c] = sc.nextInt();
            }
        }

        int postR = 0;
        int postC = 0;
        for(int r = 0; r<N;++r){
            for(int c = 0 ;c<N;++c){
                if(map[r][c] == 'P'){
                    postR = r;
                    postC = c;
                }
                if(map[r][c] == 'K') isChecked[r][c] = false;
            }
        }

    }
}
