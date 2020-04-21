import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static int cnt, N, R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        cnt = 0;

        rec(1<<N, 0, 0);

    }
    private static void rec(int n, int r, int c){
        if(n==2){
            if(r == R && c == C){
                System.out.println(cnt++);
                return;
            }
            cnt++;

            if(r == R && c+1 == C){
                System.out.println(cnt++);
                return;
            }
            cnt++;

            if(r+1 == R && c == C){
                System.out.println(cnt++);
                return;
            }
            cnt++;

            if(r+1 == R && c+1 == C){
                System.out.println(cnt++);
                return;
            }
            cnt++;
            return;
        }
        int mid = n>>1;
        rec(mid, r, c);
        rec(mid, r, c + mid);
        rec(mid, r + mid, c);
        rec(mid, r + mid, c + mid);
    }
}
