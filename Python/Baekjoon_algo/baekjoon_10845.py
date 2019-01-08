#make queue

def main():

    N = int(input())
    arr = []
    for i in range(N):

        command = input().split()

        if command[0] == 'push':
            n = command[1]
            arr.append(n)

        elif command[0] == 'pop':

            if len(arr) == 0:
                print(-1)
            else:
                print(arr.pop(0))

        elif command[0] == 'size':

            print(len(arr))

        elif command[0] == 'empty':

            if len(arr) :
                print(0)
            else:
                print(1)

        elif command[0] == 'front':

            if len(arr) == 0:
                print(-1)
            else:
                print(arr[0])

        elif command[0] == 'back':

            if len(arr) == 0:
                print(-1)
            else:
                print(arr[-1])


if __name__ == "__main__":
    main()