import java.util.*;
public class Main {
    static final int SIZE = 10000007;
    static boolean[] isNotPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        init();

        int N = sc.nextInt();
        if(N!=1) {
            while (isNotPrime[N]) {
                for (int i = 2; i < SIZE; ++i) {
                    if (!isNotPrime[i] && N % i == 0) {
                        sb.append(i + "\n");
                        N /= i;
                        break;
                    }
                }
            }
            sb.append(N+"\n");
        }
        System.out.println(sb.toString());

    }
    private static void init(){
        isNotPrime = new boolean[SIZE];

        int i, j;
        for(i=2;i*i<SIZE;i++)
            if(!isNotPrime[i])
                for(j=i*i;j<SIZE;j+=i)
                    isNotPrime[j] = true;
        isNotPrime[1] = true;
    }
}
