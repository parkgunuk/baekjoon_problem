import java.util.*;

public class Main {
    static boolean[] usedWords;
    static ArrayList<String> stringList;
    static ArrayList<Character> leftWordsList;

    static int N, K, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = 97;

        stringList = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            input = input.replaceAll("[antic]", "");
            stringList.add(input);
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < 26; i++) {
            usedWords = new boolean[26];
            usedWords[0] = true;
            usedWords[2] = true;
            usedWords[8] = true;
            usedWords[13] = true;
            usedWords[19] = true;

            backTracking(start+i);
        }
        System.out.println(ans);
    }
    private static void backTracking(int ch){

    }

}
