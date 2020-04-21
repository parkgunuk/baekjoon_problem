import java.util.*;
import java.io.*;

public class Main {
    private static long stol(String s){return Long.parseLong(s);}

    private static long pig[], tmp[];
    private static long n, days, sum;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long T = stol(br.readLine());
        while(T-->0){
            pig = new long[7];
            tmp = new long[7];
            sum = 0;
            days = 0;
            n = stol(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<6; i++) sum += (pig[i] = stol(st.nextToken()));

            while(true){
                days++;
                if (sum > n)
                    break;

                sum = 0;
                for (int i = 0; i < 6; i++) {
                    tmp[i] = pig[i] + pig[(i + 1) % 6] + pig[(i + 7) % 6] + pig[(i + 3) % 6];
                    sum += tmp[i];
                }
                for (int i = 0; i < 6; i++) pig[i] = tmp[i];
            }
            System.out.println(days);
        }
    }
}