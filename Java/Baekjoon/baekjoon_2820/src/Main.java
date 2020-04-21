import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int parents, salary;
        ArrayList<Integer> son;

        public Node(int parents, int salary){
            this.parents = parents;
            this.salary = salary;
            this.son = new ArrayList<>();
        }

    }

    private static int N, M;
    private static ArrayList<Node> list;
    private static int[] parents;
    private static long[] salary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        list = new ArrayList<>();
        parents = new int[N+1];
        salary = new long[N+1];

        int sal = stoi(br.readLine().trim());
        list.add(new Node(0, sal));
        parents[1] = 0;
        salary[1] = sal;

        for(int i = 1; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            sal = stoi(st.nextToken());
            int sup = stoi(st.nextToken());

            list.add(new Node(sup, sal));
            parents[i+1] = sup;
            salary[i+1] = sal;

            DFS(sup, i+1);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if(cmd.equals("u")) System.out.println(salary[stoi(st.nextToken())]);
            else {
                int cur = stoi(st.nextToken());
                int diff = stoi(st.nextToken());

                for(int val : list.get(cur).son){
                    salary[val] += diff;
                }
            }
        }

    }

    private static void DFS(int parent, int cur){
        if(list.get(parent).parents == 0) return;

        DFS(parents[parent], cur);
        list.get(parent).son.add(cur);

    }
}