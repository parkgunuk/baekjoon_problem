import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =
    }

    private static long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
