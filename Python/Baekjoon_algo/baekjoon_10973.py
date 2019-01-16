# 이전 순열은 앞에서 탐색을 시작해 arr[n] > arr[n+1] 인 부분이 있으면 swap한다.

def main():
    N = int(input())
    arr = [i+1 for i in range(N)]
    target = list(map(int, input().split()))
    select = []

    if target == arr :
        print(-1)

    else:
        for i in range(N-1,0,-1):
            if target[i]<target[i-1]:
                idx = i;
                break
        for j in range(idx,N):
            if(target[idx-1]>target[j]):
                select.append(target[j])
        idx2 = target.index(max(select))

        swap(target,idx-1,idx2)
        answer = target[:idx]
        sorting = target[idx:]
        sorting = sorted(sorting, reverse=True)
        answer += sorting

        for i in answer:
            print(i, end=" ")

def swap(target,a, b):

    tmp = target[a]
    target[a] = target[b]
    target[b] = tmp

if __name__=="__main__":
    main()