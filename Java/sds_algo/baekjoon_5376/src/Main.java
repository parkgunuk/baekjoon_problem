import java.lang.reflect.Parameter;
import java.util.*;

/*
solution:
1) 순환소수가 아닐 때 :
	"0."이거 떼고 남은 수랑 10^(소수자릿수)랑 약분해주면됨
2) 순환소수일 때 :
	분모: 순환되는 자릿수만큼 9를 쓰고, 뒤에 순환 안되는 자릿수만큼 0을 채워준다
	분자: ("0."뗀 전체 수) - (순환안되는 수)
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;
        int N = Integer.parseInt(sc.nextLine());

        while(N-->0){
            String[] s = sc.nextLine().split("");
            sb = new StringBuilder();

            int loopCnt = 0;
            int cnt = 0;
            boolean isLoop = false;
            for(int i = 2; i<s.length;++i){
                if(isLoop && !(s[i].equals(")")))loopCnt++;
                if(s[i].equals("(")) isLoop=true;
                if(!isLoop && !(s[i].equals(")")))cnt++;
            }

            if(loopCnt == 0){
                long mother = (int) Math.pow(10.0, (double)cnt);
                for(int i = 2 ; i<s.length;++i){
                    sb.append(s[i]);
                }
                long son = Long.parseLong(sb.toString());
                long GCD = gcd(son, mother);

                System.out.println((son/GCD)+"/"+(mother/GCD));

            } else {
                StringBuilder mother = new StringBuilder();
                StringBuilder loopNum = new StringBuilder();
                StringBuilder notLoopNum = new StringBuilder();

                for(int i = 0 ; i<loopCnt;++i) mother.append(9);
                for(int i = 0 ; i<cnt;++i) mother.append(0);

                boolean flag = false;
                for(int i = 2; i<s.length;++i){
                    if(flag && !(s[i].equals(")"))) loopNum.append(s[i]);
                    if(s[i].equals("(")) flag = true;
                    if(!flag && !(s[i].equals(")"))) {
                        loopNum.append(s[i]);
                        notLoopNum.append(s[i]);
                    }
                    if(s[i].equals(")")) flag = false;
                }

                long motherNum = Long.parseLong(mother.toString());
                long sonNum = notLoopNum.toString().equals("")?Long.parseLong(loopNum.toString()):Long.parseLong(loopNum.toString()) - Long.parseLong(notLoopNum.toString());

                long GCD = gcd(sonNum, motherNum);
                System.out.println((sonNum/GCD)+"/"+(motherNum/GCD));
            }
        }
    }
    private static long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
