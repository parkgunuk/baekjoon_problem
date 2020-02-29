import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static ArrayList<Integer> list;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp =  new int[1000001];
        list = new ArrayList<>();
        init();
        System.out.println(dp[N]);
        list.add(N);
        cal(N);
    }
    static void cal(int n){
        if(n==1 && list.size() == dp[N]+1){
            StringBuilder sb = new StringBuilder();
            for(int i : list) sb.append(i+" ");
            System.out.println(sb.toString());
            System.exit(0);
        }

        if(n == 1 && list.size() != dp[N]) return;

        if(n%3==0) {
            list.add(n/3);
            cal(n/3);
            list.remove(list.size()-1);
        }
        if(n%2==0) {
            list.add(n/2);
            cal(n/2);
            list.remove(list.size()-1);
        }
        list.add(n-1);
        cal(n-1);
        list.remove(list.size()-1);


    }

    static void init(){
        dp[2] = 1;
        dp[3] = 1;
        for(int i = 4; i<dp.length;++i){
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            int c = Integer.MAX_VALUE;

            if(i%3 == 0) a = dp[i/3]+1;
            if(i%2 == 0) b = dp[i/2]+1;
            c = dp[i-1]+1;

            dp[i] = getMin(a,b,c);
        }
    }
    static int getMin(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
