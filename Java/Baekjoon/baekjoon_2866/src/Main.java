import java.util.*;
import java.io.*;

public class Main {

    private static int res, R, C;
    private static char[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[R+1][C+1];

        for(int i = 0 ; i < R ; ++i){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; ++j){
                input[i][j] = tmp[j];
            }
        }

        res = 0;
        binarySearch(1, R-1);

        System.out.println(res);
    }

    private static void binarySearch(int left, int right){
        if(left > right) return;

        int mid = (left + right) >> 1;
        if(check(mid, R)){
            if(res < mid) res = mid;
            binarySearch(mid + 1, right);
        } else binarySearch(left, mid - 1);
    }

    private static boolean check(int s, int e){
        HashSet<String> set = new HashSet<>();
        StringBuilder sb;

        for(int c = 0; c < C ; ++c){
            sb = new StringBuilder();
            for(int r = s ; r <= e ; ++r) sb.append(input[r][c]);

            if(set.contains(sb.toString())) return false;
            else set.add(sb.toString());
        }

        return true;
    }
}
