import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static final int FIRSTCAR = 1;
    static final int SECONDCAR = 2;
    static final int EMPTY = 0;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N; // 도로의 개수
        int W; // 사건의 개수
        Point[] point; // 사건의 위치
        Point[] car = new Point[3]; // 경찰차 위치

        int sum = 0; // 움직인 거리의 합
        int[] order; // 사건 별 담당 경찰차 정보

        int[][] dp; // D_ij 는 1번 경찰차가 i를, 2번 경찰차가 j를 마지막으로 해결했을 때 최소 비용

        N = stoi(br.readLine());
        W = stoi(br.readLine());

        car[FIRSTCAR] = new Point(1, 1);
        car[SECONDCAR] = new Point(N, N);

        order = new int[W];
        point = new Point[W];
        for (int i = 0; i < W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i] = new Point(stoi(st.nextToken()), stoi(st.nextToken()));
            order[i] = EMPTY;
        }
        dp = new int[W][W];
    ]
        int first = 0;
        int second = 0;

        for (int i = 0; i < W; i++) {
            int distance1 = 0;
            int distance2 = 0;
            // 비교 1
            distance1 = calDist(car[FIRSTCAR].x, car[FIRSTCAR].y, point[i].x, point[i].y) + dp[first][second];
            // 비교 2
            distance2 = calDist(car[SECONDCAR].x, car[SECONDCAR].y, point[i].x, point[i].y) + dp[first][second];
            // assign
            if (distance1 < distance2) {
                sum += distance1;
                order[i] = FIRSTCAR;
                first = i;
                car[FIRSTCAR].x = point[i].x;
                car[FIRSTCAR].y = point[i].y;
                dp[first][second] =
            } else {
                sum += distance2;
                order[i] = SECONDCAR;
                second = i;
                car[SECONDCAR].x = point[i].x;
                car[SECONDCAR].y = point[i].y;
            }
        }

        System.out.println(sum);
        for (int policeCar : order) {
            System.out.println(policeCar);
        }
    }
    private static int calDist(int x, int y, int x1, int y1){ return Math.abs(x-x1)+Math.abs(y-y1);}

}