import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String[] s = sc.nextLine().split(" ");
            long K = Long.parseLong(s[0]);
            long C = Long.parseLong(s[1]);

            if(C == 1){
                if (K + 1 > 1e9) System.out.println("IMPOSSIBLE");
                else System.out.println(K+1);

                continue;
            } else if (K == 1) {
                System.out.println(1);
                continue;
            } else if (gcd(K, C) != 1){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            //   y:우리가 구하고자하는 답, x: K*x개를 사야함
            //     C*y = K*x + 1
            //   C*y - K*x = 1 or C*y % K = 1 (단 C,K는 서로소)

            long ans = extended_gcd(K, C);
            if (ans > 1e9) System.out.println("IMPOSSIBLE");
            else System.out.println(ans);
        }
    }

    private static long gcd(long a, long b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    // Extended Euclidean Algorithm
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
