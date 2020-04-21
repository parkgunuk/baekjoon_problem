import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N;
    private static TreeMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        map = new TreeMap<>();

        //크기순으로 나열한 배열에서 나의 왼쪽에 있으면서 나랑 가장 가까운 것의 depth,
        //나의 오른쪽에 있으면서 나랑 가장 가까운 것의 depth 중에서 더 큰것 + 1이 나의 depth입니다.

        long root = stoi(br.readLine());
        map.put(root, (long) 0);
        long res = 0;

        System.out.println(res);

        while(N-- > 1){
            long input = Long.parseLong(br.readLine());
            long depth;

            if (input > root) { // 입력값이 더 큰 경우
                depth = Long.max(
                        (map.ceilingKey(input) != null)?
                                map.get(map.ceilingKey(input)) : 0,
                        (map.floorKey(input) != null && map.floorKey(input) > root)?
                                map.get(map.floorKey(input)) : 0
                );
            } else { // 루트가 더 큰 경우
                depth = Long.max(
                        (map.ceilingKey(input) != null && map.ceilingKey(input) < root)?
                                map.get(map.ceilingKey(input)) : 0,
                        (map.floorKey(input) != null)?
                                map.get(map.floorKey(input)) : 0
                );
            }
            if (depth == 0) { // 비교할 값이 없는 높이가 1인 경우
                map.put(input, (long) 1);
                res++;
            } else { // 높이 2 이상인 것
                map.put(input, depth + 1);
                res += depth + 1;
            }

            System.out.println(res);
        }
    }
}