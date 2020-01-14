import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);

        int N = Integer.parseInt(sc.nextLine());

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) a = a.multiply(new BigInteger(st.nextToken()));
        int M = Integer.parseInt(sc.nextLine());
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < M; i++) b = b.multiply(new BigInteger(st.nextToken()));

        String ret = a.gcd(b).toString();

        if (ret.length() > 9) System.out.println(ret.substring(ret.length() - 9, ret.length()));
        else System.out.println(ret);
    }
}