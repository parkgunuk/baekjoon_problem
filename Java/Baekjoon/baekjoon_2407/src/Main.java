import java.math.BigInteger;
import java.util.*;
public class Main {
    static BigInteger[] factorial = new BigInteger[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        init();
        System.out.println(factorial[n].divide(factorial[m].multiply(factorial[n-m])));
    }
    private static void init(){
        factorial[0] = new BigInteger("1");
        for(int i = 1; i<=100; ++i) factorial[i] = new BigInteger(String.valueOf(i)).multiply(factorial[i-1]);
    }
}
