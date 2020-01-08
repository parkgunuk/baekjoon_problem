import java.util.*;
public class Main {
    static Stack<String> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("");

        int res = 0;
        int check = 0;

        stack = new Stack<>();

        for(int i = 0 ; i<arr.length;++i){
            if (check == -1) {
                System.out.println(0);
                return;
            }

            if (arr[i].equals("(") || arr[i].equals("[")) {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                if (arr[i].equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        check = stackInnerLoop("[", "(", 2);
                    }
                } else {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        check = stackInnerLoop("(", "[", 3);
                    }
                }
            }
        }while (!stack.isEmpty()) {
            if (stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[")
                    || stack.peek().equals("]")) {
                System.out.println(0);
                return;
            }
            res += Integer.parseInt(stack.pop());
        }
        System.out.println(res);
    }
    private static int stackInnerLoop(String s1, String s2, int value) {
        int result = 0;

        while (!stack.isEmpty()) {
            String top = stack.peek();

            if (top.equals(s1)) {
                return -1;
            } else if (top.equals(s2)) {
                stack.pop();
                result *= value;
                stack.push(String.valueOf(result));
                break;
            } else {
                result += Integer.parseInt(stack.pop());
            }
        }

        return result;
    }
}
