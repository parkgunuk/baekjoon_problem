#make stack

def main():

    N = int(input())
    stack = []
    for i in range(N):

        command = input().split()

        if command[0] == 'push':
            n = command[1]
            stack.append(n)

        elif command[0] == 'pop':

            if len(stack) == 0:
                print(-1)
            else:
                print(stack.pop())

        elif command[0] == 'size':

            print(len(stack))

        elif command[0] == 'empty':

            if len(stack) :
                print(0)
            else:
                print(1)

        elif command[0] == 'top':

            if len(stack) == 0:
                print(-1)
            else:
                print(stack[-1])

if __name__ == "__main__":
    main()