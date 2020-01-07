import java.util.*;
//모든 경우의 수를 visited 함수로 중복 제거해 주면서 bfs로 탐색하면 된다.

public class Main {
    static Queue<int[]> q;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        char[] N_toCharacter = str[0].toCharArray();

        q = new LinkedList<>();

        Arrays.fill(visited, false);

        visited[N] = true;
        int[] tmp = {N,0};
        q.add(tmp);


        while(q.isEmpty()){

        }
    }
    private static char[] swap(char[] value, int idx1, int idx2){
        char tmp = value[idx1];
        value[idx1] = value[idx2];
        value[idx2] = tmp;

        return value;
    }
}
