#

def main():
    N = int(input())
    arr = []

    for i in range(N):
        x, y = map(int, input().split())
        arr.append([x,y])

    arr = sorted(arr)

    for i in range(N):
        print(arr[i][0],arr[i][1])



if __name__ =="__main__":
    main()