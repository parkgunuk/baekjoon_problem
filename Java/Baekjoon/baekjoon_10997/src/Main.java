import java.util.*;

//TODO
public class Main {
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = 4*N-1;
		int C = 4*N -3;
		
		map = new char[R][C];
		
		for(int i = 0;i<R;++i) {
			Arrays.fill(map[i], ' ');
		}
		
		go(0,0,R,C);
		
		for(int i = 0;i<R;++i)
			System.out.println(map[i]);
		
	}
	static void go(int r, int c, int R, int C) {
		if(R==3 && C == 1) {
			map[r][c] = '*';
			return;
		}
		
//		go(r-2,c-2,R-4,C-4);
	}
}
