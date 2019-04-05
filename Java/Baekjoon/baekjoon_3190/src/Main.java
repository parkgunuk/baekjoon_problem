import java.util.*;

public class Main {
	static int N,K,L;
	static int[][] map;
	static int len = 1, rtime;
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static int d = 0;
	static boolean flag = false;
	static LinkedList<Node> snake = new LinkedList<>();
	static class Node{
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N= sc.nextInt();
		map = new int[N+1][N+1];
		
		K = sc.nextInt();
		for(int i=0;i<K;++i) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			map[r][c] = 1;
		}
		L = sc.nextInt();
		snake.add(new Node(1,1));
		String buf = sc.nextLine();
		
		int time = 0;
		char cmd = 'a';
		
		for(int i = 0; i<L;++i) {
			String[] str = sc.nextLine().split(" ");
			time = Integer.parseInt(str[0]);
			cmd = str[1].charAt(0);
			
			if(!flag) {
				go(cmd, time);
			}
		}
		while(!flag) {
			go('a',100);
		}
		
		System.out.println(rtime);
	}
	
	static void go(char cmd, int time) {
		time -= rtime;
		for(int i = 1 ; i<=time;++i){
			Node n = snake.peek();
			
			int nr = n.r+dir[d][0];
			int nc = n.c+dir[d][1];
			Node tmp = new Node(nr,nc);
			
			if(!(0<nr && nr <=N && 0<nc && nc<=N)) {
				rtime ++;
				flag = true;
				return;
			}
			
			if(mycontaines(tmp)) {
				rtime ++;
				flag = true;
				return;
			}
			else snake.addFirst(tmp);

			if(map[nr][nc] == 1) { 
				len++;
				map[nr][nc] = 0;
			}
			
			while(snake.size() > len) {
				snake.pollLast();
			}
			rtime++;
		}
		if(cmd =='D') d = (d+1)%4;
		else if(cmd == 'L') d = (d+3)%4;
	}
	static boolean mycontaines(Node n) {
		
		for(Node t : snake) {
			if(t.r == n.r && t.c == n.c) return true;
		}
		return false;
	}
}	
