import java.util.*;
public class Main {
	static int[][] map;
	static int[][] dice;
	static List<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		map = new int[N][M];
		dice = new int[4][3];
		for(int i = 0; i<4;++i) {
			Arrays.fill(dice[i], 0);
		}
		list = new ArrayList<Integer>();
		
		int K = sc.nextInt();
		for(int rr = 0; rr<N;++rr) {
			for(int cc = 0;cc<M;++cc) {
				map[rr][cc] = sc.nextInt();
			}
		}
		for(int i = 0 ;i<K;++i) {
			int cmd = sc.nextInt();
			switch (cmd) {
			case 1:
				if(0<=c+1 && c+1 <M) {
					east();
					c++;
					newMap(r,c);
					list.add(dice[1][1]);
				}
				break;
			case 2:
				if(0<=c-1 && c-1 <M) {
					west();
					c--;
					newMap(r,c);
					list.add(dice[1][1]);
				}
				break;
			case 3:
				if(0<=r-1 && r-1 <N) {
					north();
					r--;
					newMap(r,c);
					list.add(dice[1][1]);
				}
				break;
			case 4:
				if(0<=r+1 && r+1 <N) {
					south();
					r++;
					newMap(r,c);
					list.add(dice[1][1]);
				}
				break;
			}
		}
		for(int i : list) {
			System.out.println(i);
		}
	}
	
	static void newMap(int r, int c) {
		if(map[r][c] == 0) map[r][c] = dice[3][1];
		else {
			dice[3][1] = map[r][c];
			map[r][c] = 0;
		}
	}
	static void east() {
		int tmp = dice[1][1];
	    dice[1][1] = dice[1][0];
	    dice[1][0] = dice[3][1];
	    dice[3][1] = dice[1][2];
	    dice[1][2] = tmp;
	}
	static void west() {
		int tmp = dice[1][1];
	    dice[1][1] = dice[1][2];
	    dice[1][2] = dice[3][1];
	    dice[3][1] = dice[1][0];
	    dice[1][0] = tmp;
	}
	static void north() {
		int tmp = dice[1][1];
	    dice[1][1] = dice[2][1];
	    dice[2][1] = dice[3][1];
	    dice[3][1] = dice[0][1];
	    dice[0][1] = tmp;
	}
	static void south() {
		int tmp = dice[1][1];
	    dice[1][1] = dice[0][1];
	    dice[0][1] = dice[3][1];
	    dice[3][1] = dice[2][1];
	    dice[2][1] = tmp;
	}
}
