import java.util.*;
//M&N
public class Main {
    static int N, M;
    static int[] arr;
    static HashSet<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        set = new HashSet<>();

        st = new StringTokenizer(sc.nextLine());
        for(int i = 0 ; i<N;++i) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        getPermu(new int[M],0,0);

    }
    private static void getPermu(int[] sel, int sel_idx, int arr_idx) {

        if(sel_idx == sel.length) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<sel.length; i++) {
                sb.append(sel[i]);
                sb.append(" ");
            }
            String str = sb.toString();
            if(!set.contains(str)) {
                set.add(str);
                System.out.println(str);
            }

            return;
        }

        if(arr_idx == arr.length)
            return;

        sel[sel_idx] = arr[arr_idx];
        getPermu(sel, sel_idx+1, arr_idx+1);
        getPermu(sel, sel_idx, arr_idx+1);
    }
}
