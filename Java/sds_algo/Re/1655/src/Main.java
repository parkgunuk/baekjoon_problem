import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();

        for(int i = 1; i<=N;++i) {
            int input = Integer.parseInt(br.readLine());

            //maxheap이 minheap보다 커야한다..
            if(maxheap.size() > minheap.size()) minheap.add(input);
            else maxheap.add(input*-1);

            //maxHeap의 top은 minHeap의 top보다 작거나 같다.
            if(!maxheap.isEmpty() && !minheap.isEmpty() && (maxheap.peek() * -1) > minheap.peek() ){
                int max = (maxheap.poll() *-1);
                int min = minheap.poll();

                maxheap.add(min*-1);
                minheap.add(max);
            }

            System.out.println(maxheap.peek()*-1);
        }
    }
}
