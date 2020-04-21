import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s) { return Integer.parseInt(s);}

    static class point{
        int x, y, z;
        point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static final int size = 5, side = 4;
    static final int[][] dir = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};

    static int[][][][] rotated;
    static int[][][] maze;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        rotated = new int[side][size][size][size];
        maze = new int[size][size][size];
        ans = Integer.MAX_VALUE;

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < size; z++) {
                    maze[x][y][z] = stoi(st.nextToken());
                }
            }
        }

        rotate();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) numbers[i] = i;

        getPermu(numbers, 0);

        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void rotate(){
        for(int d = 1 ; d<side;++d){
            for(int i = 0; i<size;++i){
                rotated[0][i] = maze[i];
                for(int j = 0 ; j<size;++j){
                    for(int k = 0 ; k<size;++k){
                        rotated[d][i][j][k] = rotated[d-1][i][k][size - j - 1];
                    }
                }
            }
        }
    }

    static void getPermu(int[] numbers, int pivot) {
        if (pivot == size - 1) {
            int[][][] copy = new int[size][size][size];

            for (int a = 0; a < side; a++) {
                copy[0] = rotated[a][numbers[0]];
                for (int b = 0; b < side; b++) {
                    copy[1] = rotated[b][numbers[1]];
                    for (int c = 0; c < side; c++) {
                        copy[2] = rotated[c][numbers[2]];
                        for (int d = 0; d < side; d++) {
                            copy[3] = rotated[d][numbers[3]];
                            for (int e = 0; e < side; e++) {
                                copy[4] = rotated[e][numbers[4]];
                                if (copy[0][0][0] == 1) {
                                    ans = Math.min(ans, BFS(copy));
                                }
                            }
                        }
                    }
                }
            }
            return;
        }

        for (int i = pivot; i < size; i++) {
            swap(numbers, i, pivot);
            getPermu(numbers, pivot + 1);
            swap(numbers, i, pivot);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int BFS(int[][][] maze) {
        Queue<point> q = new LinkedList<>();
        int[][][] visited = new int[size][size][size];
        int x = 0, y = 0, z = 0;
        q.add(new point(x, y, z));
        while (!q.isEmpty()) {
            point p = q.poll();
            int cx = p.x;
            int cy = p.y;
            int cz = p.z;

            for (int d = 0; d < 6; d++) {

                int nx = cx + dir[d][0];
                int ny = cy + dir[d][1];
                int nz = cz + dir[d][2];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= size || ny >= size || nz >= size) continue;
                if (maze[nx][ny][nz] == 0 || visited[nx][ny][nz] != 0) continue;

                visited[nx][ny][nz] = visited[cx][cy][cz] + 1;
                q.add(new point(nx, ny, nz));
            }
        }

        if (visited[size - 1][size - 1][size - 1] != 0) {
            return visited[size - 1][size - 1][size - 1];
        } else {
            return Integer.MAX_VALUE;
        }
    }

}