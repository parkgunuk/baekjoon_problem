import java.util.*;

public class Main {
    static boolean[] usedWords;
    static String[] stringList;
    static int N, K, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        stringList = new String[N];

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            stringList[i] = input;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }
        K-=5;


        usedWords = new boolean[26];
        usedWords[0] = true;
        usedWords[2] = true;
        usedWords[8] = true;
        usedWords[13] = true;
        usedWords[19] = true;

        backTracking(0, 0);

        System.out.println(ans);
    }

    private static void backTracking(int ch, int cnt) {

        if (cnt == K) {
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                char[] s = stringList[i].toCharArray();
                //익히지 않은 알파벳이 있는 경우 배울 수 없는 단어
                for (int j = 0; j < s.length; j++)
                    if (!usedWords[s[j] - 'a']) {
                        flag = false;
                        break;
                    }

                if (flag)
                    tmp++;
            }
            ans = Math.max(ans, tmp);
            return;

        }
        for (int c = ch; c < 26; c++) {
            if (!usedWords[c]) {
                usedWords[c] = true;
                backTracking(c, cnt + 1);
                usedWords[c] = false;
            }
        }

    }
}
