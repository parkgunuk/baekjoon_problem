import java.util.*;

public class Main {
    static boolean[][] map;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int times = sc.nextInt();
        for(int time = 0; time<times; ++time){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            for(int x = a; x<a+10;++x){
                for(int y = b; y<b+10;++y){
                    if(!map[x][y]){
                        map[x][y] = true;
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    static void init(){
        map = new boolean[101][101];
        answer = 0;
    }
}
