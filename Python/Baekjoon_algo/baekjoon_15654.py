answer = []

def main():
    N,M = map(int, input().split())

    arr = list(map(int, input().split()))
    visited = [0]*N
    arr = sorted(arr)

    combination(arr, visited, 0, M)

def combination(arr,visitied, idx, M):
    if idx == M:
        for index in range(M):
            print(answer[index], end=' ')
        print()
        return
    for i in range(len(arr)):
        if visitied[i] == 0:
            answer.append(arr[i])
            visitied[i] = 1;
            combination(arr,visitied, idx+1,M)
            visitied[i] = 0;
            answer.pop()
if __name__=="__main__":
    main()