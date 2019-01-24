import java.util.*;
import java.io.*;

public class Main {
	

	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int days = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		int row = sc.nextInt();
	
		int[][] box = new int[row][col];
		for (int r = 0; r<row;++r) {
			for(int c = 0;c<col;++c) {
				box[r][c] = sc.nextInt();
			}
		}
		BFS(box,row,col);
	}
	public static void BFS(int[][] box, int row, int col) {

		Queue<Pair> qu = new LinkedList<Pair>();
		
		for(int r = 0; r<row;++r) {
			for(int c = 0;c<col;++c) {
				if(box[r][c] == 1) {
					qu.add(new Pair(r,c));
				}
			}
		}
		
		while (!qu.isEmpty()) {
			Pair pair  = qu.poll();
			for(int i = 0;i<4;++i) {
				int next_r = pair.x +dir[i][0];
				int next_c = pair.y +dir[i][1];
				
				if (next_r >= 0 && next_c >= 0 && next_r < row && next_c < col && box[next_r][next_c] == 0) {

					days++;
	                qu.add(new Pair(next_r, next_c));
	                
				}
			}
		}
		for (int r = 0; r<row;++r) {
			for(int c = 0; c<col;++c) {
				if(box[r][c] == 0)
					System.out.println(-1);
					return;
			}
		}
		System.out.println(days);
	}
}
class Pair{
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}