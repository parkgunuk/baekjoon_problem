import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] prime = new long[k];
        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            prime[i] = sc.nextInt();
            q.add(prime[i]);
        }

        long head = 0;

        for (int i = 0; i < n; i++) {
            // n번째 뺀 값이 n번째 수가 된다.
            head = q.poll();

            // 큐를 활용하여 삽입마다 오름차순으로 정렬됨으로써 원하는 값들을 리스트에 저장 가능.
            for (int j = 0; j < k; j++) {
                long value = head * prime[j];
                q.add(value);

                if (head % prime[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(head);

    }
}
