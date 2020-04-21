import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N, M;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> s = new TreeSet<Integer>();
        for(int i = 0; i< N; i++) {
            int t = Integer.parseInt(st.nextToken());
            s.add(t);
        }

        list = new ArrayList<Integer>(s);
        dfs(0, 0, "");
    }

    public static void dfs(int before, int len, String str) {
        if(len == M) {
            System.out.println(str);
            return;
        }

        for(int i = 0; i< list.size(); i++)
            if(list.get(i) >= before)
                dfs(list.get(i), len + 1, str + list.get(i) + " ");

    }
}