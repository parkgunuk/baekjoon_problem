import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] input = new char[R][C];

        for(int i = 0 ; i < R ; ++i){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; ++j){
                input[i][j] = tmp[j];
            }
        }
    }
}
