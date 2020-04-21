import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-->0) set.add(stoi(st.nextToken()));
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        for(int i : list) System.out.print(i+" ");
    }
}
