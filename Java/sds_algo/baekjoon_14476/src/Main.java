import java.util.*;
//left to right 의 최대 공약수 구하는 배열과
//right to left 의 최대 공약수 구하는 배열 두개를 계산 한다음에,
// 하나씩 빼가면서 두개의 값 비교.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] arr = new long[1000001];
        long[] ltor = new long[1000001];
        long[] rtol = new long[1000001];
        long res1 =0,res2 =0;

        for(int i = 0 ; i<N;++i) arr[i] = sc.nextLong();
        ltor[0] = arr[0];

        for (int i = 1; i < N; i++) ltor[i] = getGcd(ltor[i - 1], arr[i]);

        rtol[N - 1] = arr[N - 1];

        for (int i = N-2; i >=0; i--) rtol[i] = getGcd(rtol[i+1], arr[i]);

        long t = rtol[1];

        if (arr[0] < t || getGcd(arr[0], t) != t) res1 = t;

        for (int i = 1; i < N-1; i++) {
            t = getGcd(ltor[i - 1], rtol[i + 1]);
            if (arr[i] < t || getGcd(arr[i], t) != t) {
                if (res1 < t) {
                    res1 = t;
                    res2 = i;
                }
            }
        }
        if (arr[N-1] < ltor[N-2] || getGcd(arr[N-1], ltor[N-2]) != t) {
            if (res1 < t) {
                res1 = ltor[N-2];
                res2 = N-2;
            }
        }
        if (res1 == 0) System.out.println(-1);
        else System.out.println(res1+" "+arr[(int)res2]);

    }
    private static long getGcd(long x, long y){
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return Math.abs(x);
    }
}
