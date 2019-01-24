import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] heights = new String[N];
		int[] answer = new int[N];	
		
		heights = in.readLine().split(" ");
		
		for (int i=0; i<N; i++){
            for (int j=i+1; j<N; j++){
                if ((Integer.parseInt(heights[i]) > (Integer.parseInt(heights[j])))) {
                    answer[j]=i+1;
                }
            }
        }

		System.out.print(answer[0]);
        for(int i =1; i<N;++i)
        	System.out.print(" "+ answer[i]);
	}	
	

}