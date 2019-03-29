import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int len = 4*N -3;
		
		map = new char[len][len];
		
		for(int i = 0;i<len;++i) {
			Arrays.fill(map[i], ' ');
		}
		
		go(0,0,len);
		
		for(int i = 0;i<len;++i)
			System.out.println(map[i]);
	}	
	static void go(int r, int c, int len) {
		if(len==1) {
			map[r][c] = '*';
			return;
		}
		go(r+2,c+2,len-4);
		
		for(int i = 0; i<len;++i) {
			map[r][i+c] = '*';
			map[i+r][c] = '*';
			map[r+i][c+len-1] = '*';
			map[r+len-1][c+i]= '*';
		}
	}
}
