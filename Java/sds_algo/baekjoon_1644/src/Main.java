import java.util.*;
public class Main {
    static boolean[] isNotPrime;
    static final int SIZE = 4000001;
    static int[] primeArr = new int[SIZE];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        setPrime();

        int p =0, pp =0, res =0, sum =0;

        int[] arr = new int[SIZE];
        int N = sc.nextInt();

        while(true) {
            if (pp > cnt) break;
            else if (sum < N) sum += primeArr[pp++];
            else sum -= primeArr[p++];

            if (sum == N) res++;
        }

        System.out.println(res);

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
    private static void setPrime() {
        for (int i = 2; i < SIZE; i++) {
            if (!isNotPrime[i]) {
                primeArr[cnt++] = i;
            }
        } }


}
