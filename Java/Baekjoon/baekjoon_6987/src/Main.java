import java.util.*;

public class Main {
	
	static int[] wins = new int[6];
	static int[] draws = new int[6];
	static int[] defeats = new int[6];
	static int[] game1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
    static int[] game2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static String ans;
	static boolean check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = "";
		
		for(int r = 0; r<4;++r) {
			
			int total = 0;
			check = false;
			for(int i = 0;i<6;++i) {
				 
				int win = sc.nextInt();
				int draw = sc.nextInt();
				int defeat = sc.nextInt();
				
				wins[i] = win;
				draws[i] = draw;
				defeats[i] = defeat;
				
				total += (win+draw+defeat);
			}
			if(total != 30) check = false;
			else go(0);
			
			ans += ((check?1:0) + " ");
		}
		System.out.println(ans.trim());
	}
	static void go(int idx) {
		
		if(idx == 15) {
            check = true;
            return ;
        }
        
        int team1 = game1[idx];
        int team2 = game2[idx];
        
        if(wins[team1] > 0 && defeats [team2] >0) {
            wins[team1]--;
            defeats[team2]--;
            go(idx+1);
            wins[team1]++;
            defeats[team2]++;
        }
        if(defeats[team1] > 0 && wins [team2] >0) {
        	defeats[team1]--;
            wins[team2]--;
            go(idx+1);
            defeats[team1]++;
            wins[team2]++;
        }
        if(draws[team1] > 0 && draws[team2] >0) {
            draws[team1]--;
            draws[team2]--;
            go(idx+1);
            draws[team1]++;
            draws[team2]++;
        }    
	}

}


