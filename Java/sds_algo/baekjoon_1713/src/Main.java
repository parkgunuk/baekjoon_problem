import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int no;
        int vote;

        Node(int no, int vote){
            this.no = no;
            this.vote = vote;
        }
        @Override
        public int compareTo(Node o) {
            return this.no - o.no;
        }
    }

    static ArrayList<Node> candidate;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int total = sc.nextInt();
        candidate = new ArrayList<>();
        for(int i = 0 ;i<N ;++i) candidate.add(new Node(0,0));

        while(total-->0){
            int rec = sc.nextInt();
            boolean st = false;
            for(int i=0; i<candidate.size(); i++) {
                if (candidate.get(i).no == rec) {
                    candidate.get(i).vote++;
                    st = true;
                }
            }
            if(st) continue;
            candidate.add(new Node(rec, 1));
            int min = 1001;

            for(int i=0; i<candidate.size() - 1; i++) {
                if (candidate.get(i).vote < min)
                    min = candidate.get(i).vote;
            }

            for(int i=0; i<candidate.size() - 1; i++) {
                if (candidate.get(i).vote == min) {
                    candidate.remove(i);
                    break;
                }
            }
        }

        Collections.sort(candidate);
        for(int i=0; i<candidate.size(); i++)
            if(candidate.get(i).no == 0) continue;
            else System.out.print(candidate.get(i).no + " ");
    }
}
