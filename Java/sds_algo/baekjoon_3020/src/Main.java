import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int H = sc.nextInt();

        int[] down = new int[H];
        int[] up = new int[H];

        for(int i = 0;i<N;i+=2){
            down[sc.nextInt() - 1]++;
            up[sc.nextInt() - 1]++;
        }

        int[] totalDown = new int[H];
        int[] totalUp = new int[H];

        totalDown[H - 1] = down[H - 1];
        totalUp[0] = up[H - 1];

        for (int i = H - 2; i >= 0; i--) totalDown[i] = totalDown[i + 1] + down[i];
        for (int i = 1; i < H; i++) totalUp[i] = totalUp[i - 1] + up[H - i - 1];

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < H; i++) {
            int tmp = totalDown[i] + totalUp[i];
            minValue = minValue < tmp ? minValue : tmp;
        }
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            if (minValue == totalDown[i] + totalUp[i]) cnt++;
        }

        System.out.println(minValue+" "+cnt);
    }
}
