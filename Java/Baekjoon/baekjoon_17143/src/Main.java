import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int r, c, s, d, z;
        private Node(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        private void setR(int r){
            this.r = r;
        }

        private void setC(int c){
            this.c = c;
        }

        private void setS(int s){
            this.s = s;
        }

        private void setD(int d){
            this.d = d;
        }

        private void setZ(int z){
            this.z = z;
        }

        @Override
        public int compareTo(Node o) {
            if(this.c == o.c){
                if(this.r == o.r){
                    return o.z - this.z;
                }
                return this.r - o.r;
            }
            return this.c - o.c;
        }
    }

    private static int R, C, M;
    private static int[][] map, size, d;
    private static final int[][] dir = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}};
    private static ArrayList<Node> fishList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        M = stoi(st.nextToken());

        fishList = new ArrayList<>();

        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());

            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int s = stoi(st.nextToken());
            int d = stoi(st.nextToken());
            int z = stoi(st.nextToken());

            fishList.add(new Node(r-1, c-1, s, d, z));
        }

        int cur = 0;
        int res = 0;

        while(cur < C){
            Collections.sort(fishList);

            //낚시하기
            for(int i = 0 ; i < fishList.size() ; ++i){
                if(fishList.get(i).c == cur){
                    res += fishList.get(i).z;
                    fishList.remove(i);
                    break;
                }
            }

            // 상어 이동시키기
            for(Node n : fishList){
                int speed = n.s;

                int d = n.d;
                if(d == 1 || d == 2) speed = n.s % (2*(R-1));
                else if(d == 3 || d == 4) speed = n.s % (2*(C-1));

                int nr = n.r;
                int nc = n.c;

                while(speed>0){
                    nr = n.r + dir[d][0];
                    nc = n.c + dir[d][1];

                    if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                        nr = n.r; nc = n.c;
                        if(d == 1) d = 2;
                        else if(d == 2) d = 1;
                        else if(d == 3) d = 4;
                        else if(d == 4) d = 3;
                        continue;
                    }
                    speed--;

                    n.setR(nr);
                    n.setC(nc);
                    n.setD(d);
                }
            }

            map = new int[R][C];
            size = new int[R][C];
            d = new int[R][C];

            for(Node n : fishList){
                if(map[n.r][n.c] == 0){
                    map[n.r][n.c] = n.z;
                    size[n.r][n.c] = n.s;
                    d[n.r][n.c] = n.d;
                } else {
                    if(map[n.r][n.c] < n.z){
                        map[n.r][n.c] = n.z;
                        size[n.r][n.c] = n.s;
                        d[n.r][n.c] = n.d;
                    }
                }
            }

            fishList.clear();
            for(int i = 0 ; i < R ; ++i){
                for(int j = 0 ; j < C ; ++j){
                    if(map[i][j] != 0) fishList.add(new Node(i, j, size[i][j], d[i][j], map[i][j]));
                }
            }

            print();
            cur++;
        }

        System.out.println(res);
    }

    private static void print(){
        System.out.println();
        for(int i = 0 ; i < R ; ++i){
            for(int j = 0 ; j < C ; ++j){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
