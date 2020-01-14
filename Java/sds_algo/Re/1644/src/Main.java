import java.util.*;
import java.io.*;
public class Main {
    static boolean[] isPrime;
    static int[] primeNumList;
    static final int SIZE = 4000001;
    static int idx =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        int N = Integer.parseInt(br.readLine());

        int p = 0, pp =0, ans = 0, sum =0;
        while(true){
            if(pp > idx) break;
            else if (sum < N) sum += primeNumList[pp++];
            else sum -= primeNumList[p++];

            if(sum == N) ans++;
        }
        System.out.println(ans);
    }

    private static void init(){
        isPrime = new boolean[SIZE];
        primeNumList = new int[SIZE];
        Arrays.fill(isPrime, true);

        int i, j;
        idx = 0;
        for(i=2;i*i<SIZE;i++) {
            if (isPrime[i]) {
                for (j = i * i; j < SIZE; j += i)
                    isPrime[j] = false;
            }
        }
        isPrime[1] = false;
        setPrimeNumList();
    }

    private static void setPrimeNumList(){
        for(int i = 2; i<SIZE;++i){
            if(isPrime[i]) primeNumList[idx++]=i;
        }
    }
}
