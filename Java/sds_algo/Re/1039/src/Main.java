import java.io.*;
import java.util.*;
public class Main {

    private static LinkedList<String> li = new LinkedList<>();
    private static Set<String> visited;
    private static int K, answer, M;

    public static void main(String[] args) throws IOException {
        // input 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        //start 숫자의 자릿수 구하기
        M = num.length();

        if(M == 1 || check(num)) {
            System.out.println(-1);
        } else {
            int K_cnt = 0;
            int max = 0;
            // start setting
            visited = new HashSet<>();
            li.add(num);

            // BFS 시작
            while(!li.isEmpty() && K_cnt < K) {
                int q_size = li.size();
                visited.clear();
                K_cnt++;
                for(int x = 0; x < q_size; x++) {
                    // current 뽑기
                    String cur = li.poll();

                    // 앞자리수부터 일일히 비교하기
                    for(int i = 0; i < M-1; i++) {
                        for(int j = i+1; j < M; j++) {
                            // swap하고 난 후 맨 앞에 오는 숫자가 0이 아닌 거 filtering
                            if(!(i == 0 && cur.charAt(j) == '0')) {
                                // swapping
                                String sw = swap(cur, i, j);

                                // 처음 보는 숫자라면 visited와 queue에 넣어준다.
                                if(!visited.contains(sw)) {
                                    visited.add(sw);
                                    if(K_cnt < K) {
                                        li.add(sw);
                                    }
                                    // K만큼의 depth가 되었을 때 max값 비교 시작
                                    else if(K_cnt == K) {
                                        max = Math.max(max, Integer.parseInt(sw));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    private static String swap(String str, int i, int j) {
        char[] tmp = str.toCharArray();
        char t = tmp[i]; tmp[i] = tmp[j]; tmp[j] = t;
        String swapped = new String(tmp);
        return swapped;
    }

    private static boolean check(String str) {
        if(str.length() == 2 && str.charAt(str.length()-1) == '0') return true;
        return false;
    }
}

