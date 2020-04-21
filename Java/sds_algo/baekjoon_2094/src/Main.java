import java.util.*;
import java.io.*;

public class Main {

    public static final String FALSE = "false";
    public static final String TRUE = "true";
    public static final String MAYBE = "maybe";

    private static int stoi(String s){return Integer.parseInt(s);}
    static class Node {
        int y, r;
        Node(int y, int r){
            this.y = y;
            this.r = r;
        }
    }
    static final int MAX = 1<<16;
    static final int INF = 1000000000;

    static int N, M;
    static ArrayList<Node> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        arr = new ArrayList<>();

        for (int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken());
            int r = stoi(st.nextToken());
            arr.add(new Node(y,r));
        }
        M = stoi(br.readLine());
        for(int i = 0 ; i<M;++i){
            int Y = -1;
            int X = -2;
            // 중간 년도 값들의 최대 저장
            int Between = -1;
            boolean ValueY = false;
            boolean ValueX = false;
            // 모든 년도 값들이 다 있는지 체크
            boolean NOTALL = false;
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken());
            int x = stoi(st.nextToken());

            for (int j = 0; j < arr.size(); ++j){
                if(arr.get(j).y < y) continue;
                else if(arr.get(j).y == y){
                    Y = arr.get(j).r;
                    ValueY = true;
                }
                else if(arr.get(j).y > y && arr.get(j).y < x){
                    Between = Math.max(Between,arr.get(j).r);
                    cnt++;
                }
                else if(arr.get(j).y == x){
                    X = arr.get(j).r;
                    ValueX = true;
                    break;
                }
                else break;
            }
            if(cnt<x-y-1) NOTALL = true;

            // 애초에 조건 만족 안하는 경우
            if((ValueX&&Between>=X) || (ValueY&&Between>=Y) || (ValueX&&ValueY&&X>Y)){
                System.out.println(FALSE);
                continue;
            }
            // x,y 가 연속된 년도인 경우
            if(y+1==x){
                // X==Y==1 인 경우도 걸러짐..!
                if(ValueX&&ValueY) System.out.println(TRUE);
                else System.out.println(MAYBE);
                continue;
            }
            // 아래는 x,y 가 연속되지 않은 경우만 남음
            // x나 y년도 값이 1(최소) 인경우
            if(X==1 || Y==1){
                System.out.println(FALSE);
                continue;
            }
            // 모르는 값이 있는 경우
            if(NOTALL||!ValueX||!ValueY){
                System.out.println(MAYBE);
                continue;
            }
            // 중간에 빠진 년도 있는경우
            if(NOTALL){
                System.out.println(MAYBE);
                continue;
            }
            System.out.println(TRUE);
        }
    }
}
