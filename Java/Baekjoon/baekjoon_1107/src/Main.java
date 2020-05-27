import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    private static int N;
    private static boolean[] broken;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        broken = new boolean[10];

        int M = stoi(br.readLine());

        String[] foo = br.readLine().split(" ");

        for(int i = 0 ; i < M ; ++i) broken[stoi(foo[i])] = true;

        int answer = N - 100;
        if (answer < 0) answer = -answer;

        for (int i = 0; i < 1000001; ++i) {
            int c = i;
            int length = cal(c);
            if (length > 0) {
                int press = c - N;

                if (press < 0) press = -press;
                if (answer > length + press) answer = length + press;
            }
        }
        System.out.println(answer);
    }

    public static int cal(int val) {
        int res = 0;

        if ( val == 0 ) return broken[0] ? 0 : 1;

        while ( val > 0 ) {
            if ( broken[val % 10] ) return 0;
            res++;
            val /= 10;
        }
        return res;
    }

}
