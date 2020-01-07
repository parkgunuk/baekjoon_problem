import java.util.*;
import java.io.*;
//O(N)에 해결해야 한다.
// 어려운 문제..
public class Main {
    public static void main(String[] args) throws IOException {

        // 버퍼를 통해 입력 값을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");


        // 아이템 저장 덱 객체 변수 초기화
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int val[] = new int[N];

        // 버퍼를 통해 결과 값 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && val[deque.peekLast()] > val[i]) deque.pollLast();
            deque.offer(i);

            if(i-deque.peekFirst() >= L) deque.pollFirst();
            sb.append(val[deque.peekFirst()]);
            sb.append(" ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
