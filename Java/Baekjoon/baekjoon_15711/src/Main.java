import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static boolean[] isNotPrime;

    // 골드바흐 추측에 따르면 어떠한 큰 합성수는 소수*임의의 수 로 이루어져 있기 떄문에 root(4* 1e12) 인 2000000 까지만 소수를 구해도 된다.
    static final int MAX = 2000001;

    static ArrayList<Integer> primeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = stoi(br.readLine());
        primeList = new ArrayList<>();
        init();

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            long a = stol(st.nextToken());
            long b = stol(st.nextToken());

            long t = a+b;
            if(t < 4) {
                System.out.println("NO");
                continue;
            }

            if(t % 2 == 0) {
                System.out.println("YES");
                continue;
            }
            //골드바흐의 추측
            t -= 2;

            if (isPrime(t)) System.out.println("YES");
            else System.out.println("NO");

        }
    }
    private static boolean isPrime(long a){
        for(int i = 0; i < primeList.size() ; i++){
            if( (long) primeList.get(i) * primeList.get(i) <= a && a % primeList.get(i) == 0) return false;
        }
        return true;
    }
    private static void init(){
        isNotPrime = new boolean[MAX];
        isNotPrime[1] = true;
        for(int i = 2; i * i < MAX; i++) {
            if (!isNotPrime[i])
                for(int j = i * i; j < MAX; j += i)
                    isNotPrime[j] = true;
        }
        for(int i = 2; i < MAX; i++)
            if(!isNotPrime[i]) primeList.add(i);
    }
}
