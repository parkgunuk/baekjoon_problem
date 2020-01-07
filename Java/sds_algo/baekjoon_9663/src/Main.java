import java.util.*;

public class Main {
    static int[] col;
    static int N,ans=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for(int i = 1; i<=N;++i){
            col = new int[15];
            col[1]=i;
            backtracking(1);
        }
        System.out.println(ans);
    }

    private static void backtracking(int cnt){
        if(cnt == N) ans++;
        else{
            for(int r = 1; r<=N;++r){
                col[cnt+1] = r;
                if(isPossible(cnt+1)){
                    backtracking(cnt+1);
                }else{
                    col[cnt+1] = 0;
                }
            }
        }
        col[cnt]=0;
    }

    private static boolean isPossible(int c){
        for (int i = 1; i < c; i++) {
            // 같은 행, 열
            if (col[i] == col[c]) {
                return false;
            }
            // 대각선
            if (Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
                return false;
            }
        }
        return true;
    }
}