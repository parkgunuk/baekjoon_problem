import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    private static class Node{
        long x,y;
        private Node(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        N = stoi(sc.nextLine());

        Node[] list = new Node[N+1];
        for(int i = 1; i <= N ; ++i){
            st = new StringTokenizer(sc.nextLine());
            long x = stol(st.nextToken());
            long y = stol(st.nextToken());

            list[i] = new Node(x,y);
        }
        long ans = 0;

        for (int i = 2; i < N; i++) {
            ans += area(list[1], list[i], list[i + 1]);
        }

        ans = Math.abs(ans);
        if (ans % 2 == 1)
            System.out.println((ans / 2) + ".5");
        else
            System.out.println((ans / 2) + ".0");


    }

    private static long area(Node first, Node second, Node third) {
        return ((first.x * second.y + second.x * third.y + third.x * first.y)
                - (first.x * third.y + second.x * first.y + third.x * second.y));
    }
}
