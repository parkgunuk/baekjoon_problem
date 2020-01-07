import java.util.*;

public class Main {
    static long X,Y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        Y = sc.nextInt();
        long res = 0;

        if(winrateCalc(X,Y) >= 99) System.out.println(-1);
        else{
            long left = 0 ;
            long right = X;
            while(left<right){
                long mid = (left+right)/2;
                if(winrateCalc(X+mid, Y+mid) >= winrateCalc(X,Y)+1) right = mid;
                else left = mid+1;

                if(left==right) res = left;
            }
            System.out.println(res);
        }
    }
    private static long winrateCalc(long x, long y){
        long a = (100 * y / x);
        return a;
    }

}
