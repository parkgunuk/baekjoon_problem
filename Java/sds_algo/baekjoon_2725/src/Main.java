import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        int[] ans = new int[1001];
        ans[0] = 0;
        ans[1] = 2;

        for (int i = 2; i <= 1000; ++i) {
            int n = 0;
            for (int j = 1; j <= i; ++j) {
                if (getGCD(i, j) == 1)
                    n++;
            }
            ans[i] = ans[i - 1] + n;
        }

        while (testcase-->0){
            int N = Integer.parseInt(sc.nextLine());
            System.out.println(2*ans[N]-1);
        }
    }

    private static int getGCD(int a, int b){
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

}
