import java.util.*;
import java.io.*;
public class Main {
    static String[] inputs;
    static boolean[] usedWords = new boolean[26];
    static int N,K,ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())-5;

        inputs = new String[N];
        for(int i = 0;i<N;++i) inputs[i] = br.readLine();

        if (K < 0) {
            System.out.println(0);
            return;
        } else if (K == 21) {
            System.out.println(N);
            return;
        }


        usedWords[0] = true;
        usedWords[2] = true;
        usedWords[8] = true;
        usedWords[13] = true;
        usedWords[19] = true;

        backTracking(0,0);

        System.out.println(ans);
    }
    private static void backTracking(int ch, int cnt){
        if(cnt == K){
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                char[] s = inputs[i].toCharArray();
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

        } else {
            for(int i = ch ; i<26;++i){
                if(!usedWords[i]){
                    usedWords[i] = true;
                    backTracking(i,cnt + 1);
                    usedWords[i] = false;
                }
            }
        }
    }
}
