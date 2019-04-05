import java.util.*;

public class Main {
	static int N, max, cnt;
	static LinkedList<Node> list;
	static class Node{
		int s;
		int w;
		boolean st;
		Node(int s, int w, boolean st){
			this.s = s;
			this.w = w;
			this.st = st; // ±úÁ³À¸¸é true
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new LinkedList<>();
		for(int i = 0;i<N;++i) {
			list.add(new Node(sc.nextInt(), sc.nextInt(), false));
		}
		go(0);
		
		System.out.println(max);
	}
	static void go(int start) {
		
		if(start >= N) return;
		Node n = list.get(start);
		if(n.st) {
			if(start+1 < N) go(start+1);
			return;
		}
		else {
			for(int i = 0; i<N;++i) {
				Node t = list.get(i);
				if(i!=start && !t.st && !n.st) {
					n.s -= t.w;
					t.s -= n.w;
					
					if(t.s <=0) t.st = true;
					if(n.s <=0) n.st = true;
					
					for(Node s : list) {
						if(s.st) cnt++;
					}
					max = Math.max(max, cnt);
					cnt = 0;
					go(start+1);
					n.s += t.w;
					t.s += n.w;
					
					if(t.s >0) t.st = false;
					if(n.s >0) n.st = false;
				}
			}
		}
		
	}
}
