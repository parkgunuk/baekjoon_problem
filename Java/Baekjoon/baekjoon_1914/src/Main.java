import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        BigInteger ans = new BigInteger("2");
        ans = ans.pow(N).add(new BigInteger("-1"));
        System.out.println(ans.toString());
        if(N <= 20) hanoi(N, 1,2,3);
    }

    static void hanoi(int n, int start, int mid, int end) {
        //n : 원판의개수, start : 시작막대번호 mid : 징검다리 막대 번호 end : 도착지막대번호
        if (n == 1) {
            System.out.println(start+" "+end);
            return;
        }
        //n개의 원판을 시작지에서 도착지로 옮기는 과정을 아래의 3가지 과정으로
        //쪼갤수 있음.
        hanoi(n - 1, start, end, mid);
        //1번과정 : n-1개 원판을 시작막대에서 도착 막대를 거쳐 중간막대로
        System.out.println(start+" "+end);
        //2번과정 : 시작막대의 마지막 남은 1개 원판을 도착지 막대로
        hanoi(n - 1, mid, start, end);
        //3번과정 : 중간막대로 옮겼던 n-1개 원판을 다시 도착지 막대로 이동.
        return;
    }
}
