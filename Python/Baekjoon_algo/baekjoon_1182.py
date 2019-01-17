#공집합을 제외한 나머지 부분집합의 총 합 중에서 S랑 같은것
answer = []

def main():

    N, S = map(int, input().split())
    arr = list(map(int, input().split()))
    visited = [False] * N
    subset(arr,visited,0,N)
    cnt = 0
    for i in answer:
        if i == S:
            cnt+=1
    print(cnt)
def subset(arr,visitied,idx,N):
    if idx == N:
        num = []
        for i in range(len(arr)):
            if visitied[i] :
                num.append(arr[i])

        if len(num) != 0:
            answer.append(sum(num))
        return

    visitied[idx] = True
    subset(arr,visitied,idx+1,N)
    visitied[idx] = False
    subset(arr,visitied,idx+1,N)

if __name__=="__main__":
    main()
