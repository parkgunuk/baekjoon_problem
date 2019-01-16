def main():
    N = int(input())

    for i in range(N):
        arr = list(input())
        stack = []
        answer = "YES"
        for j in range(len(arr)):
            if arr[j] == '(':
                stack.append(arr[j])
            else:
                if len(stack) == 0:
                    answer = "NO";
                    break;
                else:
                    stack.pop()

        if len(stack) == 0 and answer != "NO":
            print("YES")
        else:
            print("NO")
if __name__=="__main__":
    main()