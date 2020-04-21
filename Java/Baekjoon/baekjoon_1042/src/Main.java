import java.math.BigDecimal;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = stoi(br.readLine());
        long N = stol(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; ++i) arr[i] = stoi(st.nextToken());
        long ans = 0;

        if(N == 1) {
            Arrays.sort(arr);
            for (int i = 0; i < 5; ++i) ans += arr[i];
            System.out.println(ans);
        } else {
            int[] a = new int[3];

            a[0] = Math.min(arr[0], arr[5]);
            a[1] = Math.min(arr[1], arr[4]);
            a[2] = Math.min(arr[2], arr[3]);

            Arrays.sort(a);

            BigInteger min1 = new BigInteger(String.valueOf(a[0]));
            BigInteger min2 = new BigInteger(String.valueOf(a[0] + a[1]));
            BigInteger min3 = new BigInteger(String.valueOf(a[0] + a[1] + a[2]));

            BigInteger one = new BigInteger(String.valueOf(4 * (N - 1) * (N - 2) + (N - 2) * (N - 2)));
            BigInteger two = new BigInteger(String.valueOf( 4 * (N - 1) + 4 * (N - 2)));
            BigInteger three = new BigInteger("4");

            BigInteger res = BigInteger.ZERO;

            res = res.add(min1.multiply(one));
            res = res.add(min2.multiply(two));
            res = res.add(min3.multiply(three));

            System.out.println(res.toString());
        }
    }
}
