import java.util.*;
import java.io.*;

public class Main {
    static int count = 1;

    static int[] discovered;
    static boolean[] isCutVertax;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];

        discovered = new int[N];
        isCutVertax = new boolean[N];

        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < N; i++) {
            if (discovered[i] == 0) {
                dfs(i, true);
            }
        }

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (isCutVertax[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

        for (int i = 1; i < N; i++) {
            if (isCutVertax[i]) {
                System.out.print(i + " ");
            }
        }

    }

    private static int dfs(int vertax, boolean root) {
        /* 자기보다 앞에 탐색할수 있는 경우가 있으면 단절점이 되지 않는다. */
        /* DFS스패닝트리를 만들면서 기존 트리는 그대로 사용됨 없어지는 것이 아님*/
        /* DFS스패닝 트리의 역할은 순서를 지정해 주는 것과
         * DFS스패닝 트리에서 루트가 자식을 2개 가지는지 체크 */


        discovered[vertax] = count++;
        int ret = discovered[vertax];
        // 자기랑 인접노드 중에서 가장 빨리 방문되는 노드의 순서를 저장하는 변수

        int child = 0; // 루트 노드일 경우 스패닝트리에서 자식수

        for (int i : list[vertax]) {
            if (discovered[i] == 0) {
                child++;

                int low = dfs(i, false);
                // 자식 노드가 갈수 있는 노드중 가장 일찍 방문한 노드
                // 중간에 dfs 한다는 것은 정점의 끝까지 간다는 것을 의미

                if (!root && low >= discovered[vertax]) {
                    isCutVertax[vertax] = true;
                }// low가 자기의 순서보다 늦거나 같은 경우는
                //즉 자기보다 앞에 있는 경로는 자기를 통해서 밖에 못간다. 단절점


                ret = Math.min(ret, low);
            } else {
                ret = Math.min(ret, discovered[i]);
                // 이미 방문한 정점과 ret값 비교 최소값 저장
            }
        }

        if (root && child >= 2) {
            isCutVertax[vertax] = true;
        }// 루트는 위의 방법으로 확인할 수가 없기 때문에 스패닝 트리에서
        // 자식이 두개 있다는 것은 단절점이다.

        return ret;
    }// dfs에서 다른 노드 값을 얻고 싶을때 return 아래에 사용
}
