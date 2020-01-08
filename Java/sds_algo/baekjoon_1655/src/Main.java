import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();

        for(int i = 1; i<=N;++i) {
            int input = sc.nextInt();

            if(maxheap.size() > minheap.size()) minheap.add(input);
            else maxheap.add(input*-1);

            //maxHeap의 top은 minHeap의 top보다 작거나 같다.
            if(!maxheap.isEmpty() && !minheap.isEmpty() && (maxheap.peek() * -1) > minheap.peek() ){
                int max = (maxheap.poll() *-1);
                int min = minheap.poll();

                maxheap.add(min*-1);
                minheap.add(max);
            }

            sb.append((maxheap.peek()*-1)+"\n");
        }
        System.out.println(sb.toString());

    }
}
