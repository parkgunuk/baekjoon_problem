import java.util.*;

public class Main {


    static boolean[] era = new boolean[1004000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        era[0] = era[1] = true;

        isPrime();
        int tester = sc.nextInt();

        for(int i = tester; i<era.length;++i){
            if(era[i]) continue;
            else{
                if(isPalindrome(Integer.toString(i))){
                    System.out.println(i);
                    return;
                }
            }
        }

    }

    private static boolean isPalindrome(String str){

        char[] StrToChar = str.toCharArray();

        int right = str.length()-1;
        int left = 0;

        while(true){
            if(left >= right) break;
            if(StrToChar[left] != StrToChar[right]) return false;
            right--;
            left++;
        }

        return true;
    }

    private static void isPrime(){
        for(int i =2; i<Math.sqrt(era.length);++i){
            if(era[i]) continue;
            for(int j = 2; j*i<era.length;++j){
                era[i*j] = true;
            }
        }
    }
}
