import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10001];
        int N = sc.nextInt();
        String buff = sc.nextLine();
        int idx = 0, isEmpty = 1, size = 0, front = -1, back = -1, p = 0;
        for (int i = 0; i<N;++i){
            String cmd = sc.nextLine();
            String[] arr = cmd.split(" ");

            if(arr.length > 1){
                if(arr[0].equals("push")){
                    int tmp = Integer.parseInt(arr[1]);
                    a[idx++] = tmp;
                    if(isEmpty == 1) {
                        front = tmp;
                        isEmpty = 0;
                    }
                    back = tmp;
                    size++;
                }
            }
            else{
                if(cmd.equals("pop")) {
                    if(size>0) {
                        System.out.println(a[p++]);
                        front = a[p];
                        size--;
                        if (size == 0) {
                            isEmpty = 1;
                            front = back = -1;
                        }
                    }else{
                        System.out.println(-1);
                    }
                }
                else if(cmd.equals("size")) System.out.println(size);
                else if(cmd.equals("empty")) System.out.println(isEmpty);
                else if(cmd.equals("front")) System.out.println(front);
                else if(cmd.equals("back")) System.out.println(back);
            }
        }
    }
}
