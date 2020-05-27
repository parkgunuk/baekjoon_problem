import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        arr = new long[2000002];

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            int val = stoi(st.nextToken());
            for(int i = 1 ; i * i <= val ; ++i){
                if (val%i == 0) {
                    arr[i]++;
                    if (i != val / i) arr[val / i]++;
                }
            }
        }
        long ans = 0;

        for(int i = 0 ; i < arr.length ; ++i){
            if(arr[i] < 2) continue;
            ans = Math.max(ans, arr[i] * i);
        }

        System.out.println(ans);

    }
}