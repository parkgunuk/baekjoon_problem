#Time Out..
#한번 더 생각 해봐야 할 문제
# 분할 정복으로도 해결이 가능합니다.

def main():
    N = int(input())
    stack = []
    number = []
    max_area = 0;

    number.append(0)
    for i in range(1,N+1):
        number.append(int(input()))

    number.append(0)
    stack.append(0);

    for i in range(1,N+2):
        while len(stack) != 0 and number[seek(stack)] > number[i]:
            height = number[seek(stack)]
            stack.pop()
            width = i - seek(stack) - 1
            max_area = max(max_area, width*height)
        stack.append(i)

    print(max_area)

def seek(arr):
    if len(arr) >0:
        return arr[-1]
    else:
        return 0
if __name__=="__main__":
    main()