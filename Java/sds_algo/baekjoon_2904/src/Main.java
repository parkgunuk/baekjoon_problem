
import java.util.Scanner;

public class Main {
    static int primeCount = 78698;
    static boolean notP[] = new boolean[1000001];
    static int p[] = new int[primeCount];
    static int fcnt[][] = new int[101][primeCount];
    static int pcnt = 0;

    public static void setPrime() {
        notP[0] = notP[1] = true;
        for (int i = 2; i < 1000000; i++) {
            if (notP[i] == true)
                continue;
            p[pcnt++] = i;
            for (long j = (long) i * i; j <= 1000000; j += i)
                notP[(int) j] = true;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        setPrime();

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            for (int j = 0; 1 < x; j++)
                while (x % p[j] == 0) {
                    x /= p[j];
                    fcnt[i][j]++;
                    fcnt[0][j]++;
                }
        }

        int ans = 1, ansCount = 0;
        for (int i = 0; i < pcnt; i++) {
            int q = fcnt[0][i] / N;
            if (q == 0)
                continue;

            for (int j = 1; j <= N; j++)
                if (fcnt[j][i] < q)
                    ansCount += q - fcnt[j][i];

            while (q-- > 0)
                ans *= p[i];
        }
        System.out.println(ans + " " + ansCount);
    }
}
