import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] map;
	static int cnt;
	static boolean flag;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		String buf = sc.nextLine();
		map = new char[N][M];
		
		for(int i = 0; i<N;++i) {
			map[i] = sc.nextLine().toCharArray();
		}
		flag = false;
		int rr=0, cc=0;
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<M;++c) {
				cnt = 0;
				if(map[r][c] != '.') continue;
				go(r,c);
				if(cnt>=2) {
					flag = true;
					rr = r;
					cc = c;
					break;
				}
			}
			if(flag) break;
		}
		char ans = ' ';
		if( 0<=rr-1 && rr-1 <N && 0<=rr+1 && rr+1 <N && 0<=cc-1 && cc-1 <M && 0<=cc+1 && cc+1 <M &&
			(map[rr-1][cc] == '+' || map[rr-1][cc] == '|' || map[rr-1][cc] == '1' || map[rr-1][cc] == '4') &&
			(map[rr+1][cc] == '+' || map[rr+1][cc] == '|' || map[rr+1][cc] == '2' || map[rr+1][cc] == '3') &&
			(map[rr][cc+1] == '+' || map[rr][cc+1] == '-' || map[rr][cc+1] == '3' || map[rr][cc+1] == '4') &&
			(map[rr][cc-1] == '+' || map[rr][cc-1] == '-' || map[rr][cc-1] == '1' || map[rr][cc-1] == '2')) ans ='+';
		else if( 0<=rr-1 && rr-1 <N && 0<=rr+1 && rr+1 <N &&
				(map[rr-1][cc] == '+' || map[rr-1][cc] == '|' || map[rr-1][cc] == '1' || map[rr-1][cc] == '4') &&
				(map[rr+1][cc] == '+' || map[rr+1][cc] == '|' || map[rr+1][cc] == '2' || map[rr+1][cc] == '3')) ans = '|'; // 위 와 아래
		else if( 0<=cc-1 && cc-1 <M && 0<=cc+1 && cc+1 <M &&
				(map[rr][cc+1] == '+' || map[rr][cc+1] == '-' || map[rr][cc+1] == '3' || map[rr][cc+1] == '4') &&
				(map[rr][cc-1] == '+' || map[rr][cc-1] == '-' || map[rr][cc-1] == '1' || map[rr][cc-1] == '2')) ans = '-'; // 오른쪽 왼쪽
		else if( 0<=rr+1 && rr+1 <N && 0<=cc+1 && cc+1 <M && 
				(map[rr][cc+1] == '+' || map[rr][cc+1] == '-' || map[rr][cc+1] == '3' || map[rr][cc+1] == '4') &&
				(map[rr+1][cc] == '+' || map[rr+1][cc] == '|' || map[rr+1][cc] == '2' || map[rr+1][cc] == '3')) ans = '1'; // 오른쪽 아래
		else if( 0<=rr-1 && rr-1 <N && 0<=cc+1 && cc+1 <M &&
				(map[rr-1][cc] == '+' || map[rr-1][cc] == '|' || map[rr-1][cc] == '1' || map[rr-1][cc] == '4') &&
				(map[rr][cc+1] == '+' || map[rr][cc+1] == '-' || map[rr][cc+1] == '3' || map[rr][cc+1] == '4')) ans = '2'; // 위와 오른쪽
		else if( 0<=rr-1 && rr-1 <N && 0<=cc-1 && cc-1 <M &&
				(map[rr-1][cc] == '+' || map[rr-1][cc] == '|' || map[rr-1][cc] == '1' || map[rr-1][cc] == '4') &&
				(map[rr][cc-1] == '+' || map[rr][cc-1] == '-' || map[rr][cc-1] == '1' || map[rr][cc-1] == '2')) ans = '3'; // 위와 왼쪽
		else if( 0<=rr+1 && rr+1 <N && 0<=cc-1 && cc-1 <M &&
				(map[rr+1][cc] == '+' || map[rr+1][cc] == '|' || map[rr+1][cc] == '2' || map[rr+1][cc] == '3') &&
				(map[rr][cc-1] == '+' || map[rr][cc-1] == '-' || map[rr][cc-1] == '1' || map[rr][cc-1] == '2')) ans = '4'; // 아래와 왼쪽
			
		System.out.println((rr+1)+" " + (cc+1)+" "+ans);
	
	}
	static void go(int r, int c) {
	
		for(int i = 0;i<4;++i) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			
			if(0<=nr && nr <N && 0<=nc && nc <M) {
				if(map[nr][nc] != '.') {
					if(i==0) {
						if(map[nr][nc] == 'M' || map[nr][nc] == 'Z' || map[nr][nc] == '+' || map[nr][nc] == '|' || map[nr][nc] == '2' || map[nr][nc] == '3') cnt++; 
					}
					else if(i==1) {
						if(map[nr][nc] == 'M' || map[nr][nc] == 'Z' || map[nr][nc] == '+' || map[nr][nc] == '|' || map[nr][nc] == '1' || map[nr][nc] == '4') cnt++; 
					}
					else if(i==2) {
						if(map[nr][nc] == 'M' || map[nr][nc] == 'Z' || map[nr][nc] == '+' || map[nr][nc] == '-' || map[nr][nc] == '1' || map[nr][nc] == '2') cnt++; 
					}
					else if(i==3) {
						if(map[nr][nc] == 'M' || map[nr][nc] == 'Z' || map[nr][nc] == '+' || map[nr][nc] == '-' || map[nr][nc] == '3' || map[nr][nc] == '4') cnt++; 
					}
				}
			}
		
		}
	}
	

}
