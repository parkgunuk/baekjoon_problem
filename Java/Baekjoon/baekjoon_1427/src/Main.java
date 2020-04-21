import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();

        int arr[] = new int[s.length+1];
        for(int i = 0 ; i<s.length;++i) arr[i] = ((int)s[i]-'0')*-1;
        Arrays.sort(arr);
        for(int i = 0 ; i<s.length;++i) sb.append(arr[i]*-1);

        System.out.println(sb.toString());
    }
}