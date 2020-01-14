import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A1 = sc.nextInt();
        int B1 = sc.nextInt();

        int A2 = sc.nextInt();
        int B2 = sc.nextInt();;

        int t1 = A1*B2;
        int t2 = A2*B1;

        int mod = getGcd((t1+t2), B1*B2);

        System.out.println((t1+t2)/mod+" "+B1*B2/mod);

    }
    private static int getGcd(int x, int y){
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return Math.abs(x);
    }
}
