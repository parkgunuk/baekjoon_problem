import java.util.*;
public class Main {
    static int[] prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        prime = new int[N+1];

        Arrays.fill(prime, -1);

        isPrime(N+1,K);

    }
    private static void isPrime(int N,int K) {
        int cnt =0;
        int ans = 0;
        for(int i =2;i<N;++i) {
            if(prime[i] == -1) {
                prime[i] = 1;
                cnt++;
                ans =i;
                if(cnt==K) {
                    System.out.println(ans);
                    return;
                }
                for(int j = 2;(i*j)<N;++j) {
                    if(prime[i*j]==0) continue;
                    prime[i*j] = 0;
                    cnt++;
                    ans=i*j;
                    if(cnt==K) {
                        System.out.println(ans);
                        return;
                    }
                }
            }
        }
    }
}
