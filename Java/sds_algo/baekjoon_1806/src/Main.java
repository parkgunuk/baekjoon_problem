import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long S = sc.nextLong();

        int[] arr = new int[N+1];

        for(int i = 0 ; i<N;++i) arr[i] = sc.nextInt();

        int p = 0, pp =0, res = -1;
        long sum = 0;

        while(true){
            if(sum>=S){
                if(res == -1) res = pp-p;
                else res = res>(pp-p)?(pp-p):res;
                sum-=arr[p++];
            }
            else if(pp == N) break;
            else sum+=arr[pp++];
        }
        System.out.println(res<0?0:res);
    }
}
