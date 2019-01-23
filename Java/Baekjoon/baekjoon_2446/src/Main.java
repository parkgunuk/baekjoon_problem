import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int SIZe = 2*N-1;
		
		for(int i = 0;i<N-1;++i) {
			for(int j = 0;j<i;++j) {
				System.out.print(" ");
			}
			for (int j = 0;j<SIZe-2*i;++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0;i<N;++i) {
			for (int j = N-i-1; j>0;--j) {
				System.out.print(" ");
			}
			for (int j = 0;j<i*2+1;++j) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
