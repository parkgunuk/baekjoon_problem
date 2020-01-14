import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long ans = 0;

        if(cal(X,Y)>=99) System.out.println(-1);
        else{
            long left = 0;
            long right = X;
            while(left<right){
                long mid = (left+right)/2;
                if(cal(X+mid, Y+mid) >= cal(X,Y)+1) right = mid;
                else left = mid+1;

                if(left==right) ans = left;
            }
            System.out.println(ans);
        }
    }
    private static long cal(long x, long y){
        return (y*100)/x;
    }
}
