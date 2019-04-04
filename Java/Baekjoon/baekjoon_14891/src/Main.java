import java.util.*;
public class Main {
	static int[] topni1;
	static int[] topni2;
	static int[] topni3;
	static int[] topni4;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		topni1 = new int[8];
		topni2 = new int[8];
		topni3 = new int[8];
		topni4 = new int[8];
		ans = 0;
		
		String[] str = sc.nextLine().split("");
		for(int i =0;i<8;++i) {
			topni1[i] = Integer.parseInt(str[i]);
			
		}
		str = sc.nextLine().split("");
		for(int i =0;i<8;++i) {
			topni2[i] = Integer.parseInt(str[i]);
			
		}
		str = sc.nextLine().split("");
		for(int i =0;i<8;++i) {
			topni3[i] = Integer.parseInt(str[i]);
			
		}
		str = sc.nextLine().split("");
		for(int i =0;i<8;++i) {
			topni4[i] = Integer.parseInt(str[i]);
			
		}
		
		int K = sc.nextInt();
		for(int i = 1;i<=K;++i) {
			int topni = sc.nextInt();
			int cmd = sc.nextInt();
			
			if(topni == 1) go1(cmd,0);
			else if(topni ==2) go2(cmd,0);
			else if(topni ==3) go3(cmd,0);
			else if(topni ==4) go4(cmd,0);
			
		}
		cal();
		System.out.println(ans);
	
	}
	static void go1(int cmd, int where) {
		if(topni1[2] == topni2[6]) command(cmd,topni1);
		else {
			if(where != 2) go2(-cmd,1);
			command(cmd,topni1);
		}
	}
	static void go2(int cmd,int where) {
		if(where == 0 && topni1[2] == topni2[6] && topni2[2] == topni3[6]) command(cmd,topni2);
		else if(where == 0){
			if(topni1[2] != topni2[6] && topni2[2] != topni3[6]) {
				go1(-cmd,2);
				go3(-cmd,2);
				command(cmd,topni2);
			}
			else if (topni1[2] == topni2[6] && topni2[2] != topni3[6]){
				go3(-cmd,2);
				command(cmd,topni2);
			}
			else if(topni1[2] != topni2[6] && topni2[2] == topni3[6]) {
				go1(-cmd,2);
				command(cmd,topni2);
			}
		}
		else if(where == 1){
			if(topni2[2] != topni3[6]) go3(-cmd,2);
			command(cmd,topni2);
		}
		else if(where == 3) {
			if(topni1[2] != topni2[6]) go1(-cmd,2);
			command(cmd,topni2);
		}
	}
	static void go3(int cmd, int where) {
		if(where == 0 && topni2[2] == topni3[6] && topni3[2] == topni4[6]) command(cmd,topni3);
		else if(where == 0) {
			if(topni2[2] != topni3[6] && topni3[2] != topni4[6]) {
				go2(-cmd, 3);
				go4(-cmd, 3);
				command(cmd,topni3);
			}
			else if(topni2[2] == topni3[6] && topni3[2] != topni4[6]) {
				go4(-cmd,3);
				command(cmd,topni3);
			}
			else if(topni2[2] != topni3[6] && topni3[2] == topni4[6]) {
				go2(-cmd,3);
				command(cmd,topni3);
			}
		}
		else if(where == 2) {
			if(topni3[2] != topni4[6]) go4(-cmd,3);
			command(cmd,topni3);
		}
		else if(where == 4) {
			if(topni2[2] != topni3[6]) go2(-cmd,3);
			command(cmd,topni3);
		}
		
	}
	static void go4(int cmd, int where) {
		if(topni4[6] == topni3[2]) command(cmd,topni4);
		else {
			if(where != 3) go3(-cmd,4);
			command(cmd,topni4);
		}
	}
	
	static void command(int cmd, int[] a) {
		if(cmd == 1) right(a);
		else left(a);
	}
	
	static void right(int[] a) {
		int tmp = a[0];
		for(int i = a.length-1;i>0;--i) {
			a[(i+1)%8] = a[i];
		}
		a[1] = tmp;
	}
	static void left(int[] a) {
		int tmp = a[0];
		for(int i = 1;i<a.length;++i) {
			a[i-1] = a[i];
		}
		a[7]=tmp;
	}
	static void cal() {
		ans = topni1[0] + 2*topni2[0] + 4*topni3[0] +8*topni4[0];
	}

}
