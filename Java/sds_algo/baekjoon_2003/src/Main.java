import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N+1];

        for(int i = 0 ; i<N;++i) arr[i] = sc.nextInt();

        int p = 0, pp = 0, res = 0, sum = 0;
        while(true){
            if(sum >= M) sum -= arr[p++];
            else if(pp == N) break;
            else sum+=arr[pp++];

            if(sum == M) res++;
        }
        System.out.println(res);
    }
}
