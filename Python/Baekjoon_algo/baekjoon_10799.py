# 쇠파이프 문제

def main():
    N = input()
    arr = []

    for i in range(len(N)):
        arr.append(N[i])

    bar = 0
    cnt = 0
    bar_stack = []
    for idx in range(len(arr)):
        if arr[idx] == '(':
            bar_stack.append(arr[idx])
            bar += 1
        elif arr[idx] == ')':
            bar_stack.pop()
            bar -= 1
            if arr[idx-1] == '(':
                cnt += bar
            else:
                cnt+=1
    print(cnt)
if __name__ == "__main__":
    main()