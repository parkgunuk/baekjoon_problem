import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String[] list = new String[4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = br.readLine().split(" ");
		
		for(int i = 0; i<4;++i)
			System.out.println(list[i]);
		
	}

}
