import java.util.*;
import java.io.*;
public class Main {

    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        rec(1,sb);


    }

    private static void rec(int n, StringBuilder sb){
        if(check(sb.toString())) return;
        if(n==N){
            System.out.println(sb.toString());
            System.exit(0);
//            return;
        }
        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            rec(n+1,sb);
            sb.delete(sb.length()-1, sb.length());
        }
    }

    private static boolean check(String val){
        for (int i = 1; i <= val.length() / 2; i++) {
            for (int j = 0; j + 2 * i <= val.length(); j++) {
                if (val.substring(j, j + i).equals(val.substring(j + i, j + 2 * i))) {

                    return true;
                }
            }
        }
        return false;
    }
}
