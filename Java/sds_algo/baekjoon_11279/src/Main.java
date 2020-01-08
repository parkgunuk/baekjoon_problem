import java.util.*;

public class Main {
//    static class Node implements Comparable<Node>{
//        int value;
//
//        Node(int value){
//            this.value = value;
//        }
//        @Override
//        public int compareTo(Node o) {
//            return o.value - this.value;
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        PriorityQueue<Node> q = new PriorityQueue<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0 ;i<N;++i){
            int input = sc.nextInt();
            if(input == 0) {
                if (q.size() == 0) System.out.println(0);
//                else System.out.println(q.poll().value);
                else System.out.println(q.poll() * -1);
            } else {
//                q.add(new Node(input));
                q.add(input*-1);
            }
        }
    }
}
