import java.io.IOException;
import java.util.*;

public class Main {
    static class Trie{
        private TrieNode root;

        public Trie() {
            root = new TrieNode('\u0000');
        }

        public void insert(String word) {
            if (search(word) == true) return;
            TrieNode current = root;

            for (char ch : word.toCharArray() ) {
                TrieNode child = current.hasSubNode(ch);
                if (child != null) {
                    current = child;
                }
                else {
                    current.childNodes[ch-'A'] = new TrieNode(ch);
                    current = current.hasSubNode(ch);
                }
            }
            current.leaf = true;
        }

        public boolean search(String word) {
            TrieNode current = root;

            //문자열을 문자 배열로 쪼개서 차례대로 비교
            for (char ch : word.toCharArray() ) {
                if (current.hasSubNode(ch) == null) return false; //해당 문자의 노드가 없으면 false리턴
                else current = current.hasSubNode(ch);//해당 문자가 존재하면 현재 노드에
                //서브 노드 저장해서 단계별로 내려감
            }
            if (current.leaf == true) return true; //현재 노드가 단어의 끝인지 검사

            return false;
        }
    }

    static class TrieNode{
        char ch;
        boolean leaf;
        TrieNode[] childNodes;

        public TrieNode(char c) {
            childNodes = new TrieNode[27];
            leaf = false;
            ch = c;
        }

        public TrieNode hasSubNode(char nextChar){
            return childNodes[nextChar-'A'];
        }
    }

    static int[][] dir = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};
    static int[] score = {0,0,1,1,2,3,5,11};
    static boolean[][] visited;
    static HashSet<String> set;
    static String[][] boggle;
    static Trie trie;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        trie = new Trie();
        StringBuilder sb;

        int W = Integer.parseInt(sc.nextLine());

        for(int i = 0 ; i<W;++i){
            String str = sc.nextLine();
            trie.insert(str);
        }
        sc.nextLine();

        int b = Integer.parseInt(sc.nextLine());
        set = new HashSet<>();
        while(b-->0){
            visited = new boolean[5][5];
            set.clear();
            boggle = new String[5][];

            for(int i = 0 ; i<4;++i) boggle[i] = sc.nextLine().split("");

            for(int r = 0 ; r<4;++r){
                for(int c = 0 ; c<4;++c){
                    visited[r][c] = true;
                    sb = new StringBuilder();
                    DFS(r, c, sb.append(boggle[r][c]), 1);
                    visited[r][c] = false;
                }
            }

            String maxString = "";
            int point = 0;

            for(String s : set){
                point+=score[s.length()-1];
                if(maxString.length() < s.length()) maxString = s;
            }

            ArrayList<String> list = new ArrayList<>();

            for(String s : set){
                if(s.length() == maxString.length()) list.add(s);
            }

            Collections.sort(list);

            System.out.println(point+" "+list.get(0)+" "+set.size());

            sc.nextLine();
        }
    }
    private static void DFS(int sr, int sc, StringBuilder sb, int cnt){
        if(cnt > 8) return;

        if(trie.search(sb.toString())) set.add(sb.toString());


        for(int i = 0 ;i<8;++i){
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];

            if(nr<0 || nr>=4 || nc<0 || nc>=4 || visited[nr][nc]) continue;

            visited[nr][nc] = true;
            int nowLen = sb.length();
            DFS(nr, nc, sb.append(boggle[nr][nc]), cnt+1);
            sb.delete(nowLen, sb.length());
            visited[nr][nc] = false;
        }
    }
}
