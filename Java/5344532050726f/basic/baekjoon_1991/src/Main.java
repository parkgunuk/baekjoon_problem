import java.util.*;

public class Main {
    static int[][] tree;
    static String pre = "", in = "", post = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        tree = new int[27][2];
        String buff = sc.nextLine();
        for (int i = 0; i < 26; i++) {
            tree[i][0] = -1;
            tree[i][1] = -1;
        }
        for(int i = 0 ;i<N;++i){
            String[] tmp = sc.nextLine().split(" ");
            tree[tmp[0].charAt(0) - 'A'][0] = tmp[1].charAt(0) - 'A';
            tree[tmp[0].charAt(0) - 'A'][1] = tmp[2].charAt(0) - 'A';
        }
        Preorder(0);
        Inorder(0);
        Postorder(0);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    static void Preorder(int idx){
        if(idx < 0 ) return;
        else{
            pre += (char)(idx+'A');
            Preorder(tree[idx][0]);
            Preorder(tree[idx][1]);
        }
    }
    static void Inorder(int idx){
        if(idx < 0) return;
        else{
            Inorder(tree[idx][0]);
            in += (char)(idx+'A');
            Inorder(tree[idx][1]);
        }
    }
    static void Postorder(int idx){
        if(idx < 0) return;
        else{
            Postorder(tree[idx][0]);
            Postorder(tree[idx][1]);
            post += (char)(idx+'A');
        }
    }
}
