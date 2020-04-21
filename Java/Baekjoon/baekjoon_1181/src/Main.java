import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node>{
        String s;
        int len;
        Node(String s){
            this.s = s;
            len = s.length();
        }

        @Override
        public int compareTo(Node o) {
            if(this.len == o.len){
                return this.s.compareTo(o.s);
            }
            return this.len - o.len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i<N;++i){
            set.add(br.readLine());
        }
        for(String s : set) list.add(new Node(s));
        Collections.sort(list);
        for(Node n : list){
            System.out.println(n.s);
        }
    }
}
