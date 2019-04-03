import java.util.*;
//TODO
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double V = sc.nextDouble();
		
		int t = (int) (((V-B-1)/(A-B)) +1);
		System.out.println(t);
	}

}
