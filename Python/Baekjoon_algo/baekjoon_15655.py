answer = []

def main():
    N,M = map(int, input().split())

    arr = list(map(int, input().split()))
    visited = [False]*N
    arr = sorted(arr)

    combination(arr,visited,0,N,M)

    result = []
    for i in answer:
        if len(i) == M:
            result.append(i)

    for i in result:
        for j in i:
            print(j, end=' ')
        print()
def combination(arr,visitied,idx,N,M):
    if idx == N:
        num = []
        for i in range(len(arr)):


            if visitied[i] :
                num.append(arr[i])

        answer.append(num)
        return

    visitied[idx] = True
    combination(arr,visitied,idx+1,N,M)
    visitied[idx] = False
    combination(arr,visitied,idx+1,N,M)

if __name__=="__main__":
    main()