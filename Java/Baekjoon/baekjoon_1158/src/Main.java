import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i<=N;++i) list.add(i);

        int idx = K-1;
        sb.append("<");
        while(!list.isEmpty()){
            idx %= list.size();
            int tmp = list.remove(idx);
            if(list.size() == 0) sb.append(tmp+">");
            else sb.append(tmp+", ");
            idx+=(K-1);
        }

        System.out.println(sb.toString());
    }
}
