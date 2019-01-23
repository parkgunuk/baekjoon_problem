import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] cmd = new String[2];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i<N;++i) {
			String string = in.readLine();
			cmd = string.split(" ");
			
			switch (cmd[0]) {
			case "push":
				stack.push(Integer.parseInt(cmd[1]));
				break;
			case "pop":
				if(stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if (stack.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
				break;
			case "top":
				if (stack.isEmpty())
					System.out.println("-1");
				else
					System.out.println(stack.peek());
				break;
			}
		}
		
	}

}
