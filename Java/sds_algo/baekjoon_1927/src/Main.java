import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i<N;++i){
            int input = sc.nextInt();

            if(input == 0) {
                if(q.size() == 0) System.out.println(0);
                else System.out.println(q.poll());
            } else {
                q.add(input);
            }
        }
    }
}
