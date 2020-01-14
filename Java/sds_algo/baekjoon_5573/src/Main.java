import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] numVisit;
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int H = Integer.parseInt(st.nextToken());
//        int W = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());

//        for(int i =0; i<H; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j =0; j<W; j++){
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        numVisit = new int[H+1][W+1];

        for(int h = 0;h<H;++h){
            st = new StringTokenizer(sc.nextLine());
            for(int w = 0 ; w<W;++w){
//                map[h][w] = sc.nextInt(); //메모리 초과
                map[h][w] = Integer.parseInt(st.nextToken());
            }
        }



        numVisit[0][0] = N-1;
        for(int r=0; r< H; r++) {
            for(int c=0; c<W; c++) {
                numVisit[r+1][c] += numVisit[r][c] / 2;
                numVisit[r][c+1] += numVisit[r][c] / 2;

                if((map[r][c]+ numVisit[r][c]) % 2 == 1) numVisit[r+1][c] += (numVisit[r][c]%2);
                else numVisit[r][c+1] += (numVisit[r][c]%2);

            }
        }

        int dH = 0;
        int dW = 0;
        while (dH < H && dW < W) {
            if ((map[dH][dW] + numVisit[dH][dW]) % 2 == 0) dH++;
            else dW++;
        }
        System.out.println((dH+1)+" "+(dW+1));
    }
}
