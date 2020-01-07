import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] cmd;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i<N;++i) {
            String string = sc.nextLine();
            cmd = string.split(" ");

            switch (cmd[0]) {
                case "push":
                    stack.push(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    if(stack.isEmpty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "top":
                    if (stack.isEmpty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }
    }
}
