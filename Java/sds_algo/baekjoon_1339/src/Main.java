import java.util.*;

public class Main {
    static int[] value;
    static int ans,N;
    static char[][] str;
    static boolean[] visited;
    static HashSet<Character> set;
    static char[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        value = new int[26];
        ans = 0;
        str = new char[N][];
        visited = new boolean[10];

        for(int i = 0; i<N;++i)
            str[i] = sc.nextLine().toCharArray();

        set = new HashSet<>();

        for(int i = 0;i<N;++i){
            for(int j = 0 ;j<str[i].length;++j){
                set.add(str[i][j]);
            }
        }

        list = new char[set.size()];

        int cnt = 0;
        for(char s : set){
            list[cnt++] = s;
        }

        backtracking(0);

        System.out.println(ans);
    }
    private static void backtracking(int cnt){
        if(cnt >= set.size()){
            ans = ans > getAnswer() ? ans : getAnswer();
            return;
        }
        else{
            for(int i = 9 ; i>=0;--i){
                if(!visited[i]){
                    visited[i] = true;
                    value[list[cnt]-'A'] = i;
                    backtracking(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
    private static int getAnswer(){
        int sum = 0;
        for(int i = 0;i<N;++i){
            int tmp = 0;
            for(int j = 0;j<str[i].length;++j){
                tmp = tmp*10 + value[str[i][j]-'A'];
            }
            sum+=tmp;
        }
        return sum;
    }
}
