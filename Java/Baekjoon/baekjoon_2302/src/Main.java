import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static long[] fibo;
    static int N,M;
    static long ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        M = stoi(br.readLine());

        fibo = new long[41];
        init();

        int a = 0, b;
        while(M-->0){
            b = stoi(br.readLine());
            ans *= fibo[b-a-1];
            a = b;
        }
        ans *= fibo[N-a];
        System.out.println(ans);
    }

    private static void init(){
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i<=40;++i){
            fibo[i] = fibo[i-2] + fibo[i-1];
        }
    }
}
