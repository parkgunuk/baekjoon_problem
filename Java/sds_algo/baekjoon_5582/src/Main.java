import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] map = new int[s2.length+1][s1.length+1];

        int ans = 0;
        for(int r = 1 ; r<=s2.length;++r){
            for(int c = 1 ; c<=s1.length;++c){
                if(s2[r-1] == s1[c-1]) {
                    map[r][c] = map[r-1][c-1]+1;
                    ans = ans>map[r][c]?ans:map[r][c];
                }
            }
        }
        System.out.println(ans);
    }
}
