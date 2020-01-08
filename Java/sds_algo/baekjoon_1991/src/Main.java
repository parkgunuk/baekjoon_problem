import java.util.*;
public class Main {
    static int[][] tree;
    static String pre="",in="",post="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];
        for(int i = 0 ; i<N;++i){
            String[] tmp = sc.nextLine().split(" ");
            tree[tmp[0].charAt(0) - 'A'][0] = (tmp[1].charAt(0) - 'A');
            tree[tmp[0].charAt(0) - 'A'][1] = (tmp[2].charAt(0) - 'A');
        }

        preoredr(0);
        inorder(0);
        postorder(0);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    private static void preoredr(int idx){
        if(idx<0) return;
        else{
            pre+=(char)(idx+'A');
            preoredr(tree[idx][0]);
            preoredr(tree[idx][1]);
        }
    }
    private static void inorder(int idx){
        if(idx<0) return;
        else{
            inorder(tree[idx][0]);
            in += (char)(idx+'A');
            inorder(tree[idx][1]);
        }
    }
    private static void postorder(int idx){
        if(idx<0) return;
        else{
            postorder(tree[idx][0]);
            postorder(tree[idx][1]);
            post += (char)(idx+'A');
        }
    }
}
