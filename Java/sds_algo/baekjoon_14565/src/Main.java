import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long A = sc.nextLong();

        long sumInverse = N-A;
        long mulInverse = -1;

        if(gcd(N,A)!= 1) System.out.println(sumInverse+" "+mulInverse);
        else System.out.println(sumInverse+" "+extended_gcd(N,A));

    }

    private static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    private static long extended_gcd(long a, long b){
        long r, q, tmpA = a, t, t1 = 0, t2 = 1;

        while (b != 0){
            q = a / b;
            r = a%b;
            t = t1 - q*t2;
            a = b;
            b = r;
            t1 = t2;
            t2 = t;
        }
        while (t1<0) t1 += tmpA;
        return t1;
    }
}
