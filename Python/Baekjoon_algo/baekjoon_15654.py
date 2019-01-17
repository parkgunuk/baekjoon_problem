answer = []

def main():
    N,M = map(int, input().split())

    arr = list(map(int, input().split()))
    visited = [False]*N
    arr = sorted(arr)

    combination(arr, visited, 0, M)

    result = []
    # for i in answer:
    #     if len(i) == M:
    #         result.append(i)
    #
    # for i in result:
    #     for j in i:
    #         print(j, end=' ')
    #     print()
def combination(arr,visitied, idx, M):
    if idx == M:
        print(answer)
        return
    for i in range(len(arr)):
        if visitied[i]
            answer.append(arr[i])
            visitied[i] =
            combination(arr,idx+1,M)
if __name__=="__main__":
    main()