import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int arr[];
    static boolean visited[];
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        visited = new boolean[n+1];
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        dfs(0,"");

        for(String i : set) {
            System.out.println(i);
        }
    }

    private static void dfs(int d, String str) {
        if(d == m) {
            set.add(str);
            return ;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(d+1,str+arr[i]+" ");
                visited[i] = false;
            }
        }
    }
}