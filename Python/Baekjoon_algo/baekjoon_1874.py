# 스택의 개념을 다시 한번 생각해 보자.

stack = []
def main():
    N = int(input())
    target = [0]*N
    answer = []

    for i in range(N):
        target[i] = int(input())

    idx = 0
    for i in range(1,N+1):
        answer.append(push(i))
        while (len(stack) != 0 and target[idx] == stack[-1]):
            idx+=1
            answer.append(pop())

    if len(stack) != 0:
        print("NO")
    else:
        print("\n".join(answer))

def push(value):
    stack.append(value)
    #print(stack)
    return "+"

def pop():
    stack.pop()
    #print(stack)
    return "-"
if __name__=="__main__":
    main()
