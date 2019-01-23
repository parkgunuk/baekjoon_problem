import java.util.*;
import java.io.*;

public class Main {
	static char[] arr = {'A', 'B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static Stack<Double> stack = new Stack<Double>();
	static Stack<Character> op = new Stack<Character>();
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String postfix = in.readLine();
		
		for(int i = 0; i<N;++i) {
			map.put(arr[i], Integer.parseInt(in.readLine()));
		}
		double answer = calcul(postfix);
		System.out.printf("%.2f",answer);
	}
	
	public static Double calcul(String postfix) {
		double value1, value2;
		for(int i = 0; i<postfix.length();++i) {
			char ch = postfix.toCharArray()[i];
			switch (ch) {
				case '*':
					value1 = stack.pop();
					value2 = stack.pop();
					
					stack.push(value2*value1);
					break;
				case '/':
					value1 = stack.pop();
					value2 = stack.pop();
					
					stack.push(value2/value1);
					break;
				case '+':
					value1 = stack.pop();
					value2 = stack.pop();
					
					stack.push(value2+value1);
					break;
				case '-':
					value1 = stack.pop();
					value2 = stack.pop();
					
					stack.push(value2-value1);
					break;
			default:
				stack.push((double)map.get(ch));
				break;
			}
		}
		return (double) stack.peek();
	}

}
