import java.util.*;

public class Main {
    static int L,C;
    static char[] str;
    public static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        visited = new boolean[C];

        String buff = sc.nextLine();

        str = new char[C];

        for (int i = 0; i < C; i++) {
            str[i] = sc.next().charAt(0);
        }
        Arrays.sort(str);
        for (int i = 0; i <= C - L; i++) {
            visited = new boolean[26];
            backtracking(i, 1, "" + str[i]);
        }
        System.out.println(sb.toString());

    }

    private static void backtracking(int v, int cnt, String s){
        int idx = str[v] - 'a';
        visited[idx] = true;

        if (L == cnt) {
            if (isSatisfy()) {
                sb.append(s + "\n");
            }
        } else {
            for (int i = v + 1; i < C; i++) {
                if (!visited[str[i] - 'a']) {
                    backtracking(i, cnt + 1, s + str[i]);
                }
            }
        }

        // backtracking
        visited[idx] = false;
    }
    private static boolean isSatisfy() {
        int vowel = 0;
        int consonant = 0;

        if (visited[0]) ++vowel;
        if (visited[4]) ++vowel;
        if (visited[8]) ++vowel;
        if (visited[14]) ++vowel;
        if (visited[20]) ++vowel;

        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                continue;
            }

            if (visited[i]) {
                ++consonant;
            }
        }

        if (vowel > 0 && consonant > 1) {
            return true;
        }
        return false;
    }

}


