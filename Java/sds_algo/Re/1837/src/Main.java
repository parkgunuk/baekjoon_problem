import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        init(K+1);
        for(int i = 2;i<K;++i){
            if(isPrime[i] && P.mod(new BigInteger(String.valueOf(i))) == BigInteger.ZERO){
                System.out.println("BAD "+i);
                return;
            }
        }
        System.out.println("GOOD");
    }
    private static void init(int size){
        isPrime = new boolean[size+1];
        Arrays.fill(isPrime, true);
        int i,j;
        for(i = 2; i*i<size;++i){
            if(isPrime[i])
                for(j=i*i;j<size;j+=i)
                    isPrime[j] = false;
        }
    }
}
