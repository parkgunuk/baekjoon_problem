import java.util.*;

public class Main {
	static int N;
	static int[] value;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] count = new int[4];
	static char[] cmd;
	static int[] select;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		value = new int[N];
		for(int i = 0;i<N;++i) value[i] = sc.nextInt();
		int cnt = 0;
		for(int i = 0;i<4;++i) {
			count[i] = sc.nextInt();
			if(count[i] != 0) cnt+=count[i];
		}
		
		select = new int[cnt];
		
		go(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void go(int lev) {
		if(lev == N-1) {
			
			int val = cal();
			
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		for(int i = 0;i<4;++i) {
			if(count[i]<=0) continue;
			select[lev] = i;
			count[i]--;
			go(lev+1);
			count[i]++;
		}
	}
	static int cal() {
		Stack<Integer> stack = new Stack<>();
		int idx = 0;
		for(int i = 0;i<N;++i) {
			if(stack.size() < 2 ) stack.push(value[i]);
			else {
				int a = stack.pop();
				int b = stack.pop();
				int c = select[idx++];
				
				switch (c) {
					case 0:
						stack.push(b+a);
						break;
					case 1:
						stack.push(b-a);
						break;
					case 2:
						stack.push(b*a);
						break;
					case 3:
						stack.push(b/a);
						break;
				}
				stack.push(value[i]);
			}
		}
		
		int a = stack.pop();
		int b = stack.pop();
		int c = select[idx++];
		
		switch (c) {
			case 0:
				stack.push(b+a);
				break;
			case 1:
				stack.push(b-a);
				break;
			case 2:
				stack.push(b*a);
				break;
			case 3:
				stack.push(b/a);
				break;
		}
		
		return stack.peek();
	}
}
