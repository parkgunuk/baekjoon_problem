answer = []

def main():
    N,M = map(int, input().split())

    arr = list(map(int, input().split()))
    arr = sorted(arr)
    combination(arr, 0, M)

def combination(arr, idx, M):
    if idx == M:

        for index in range(M):
            print(answer[index], end=' ')
        print()
        return

    for i in range(len(arr)):
        answer.append(arr[i])
        combination(arr, idx+1,M)
        answer.pop()

if __name__=="__main__":
    main()