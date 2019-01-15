# 이전 순열은 앞에서 탐색을 시작해 arr[n] > arr[n+1] 인 부분이 있으면 swap한다.

def main():
    N = int(input())
    arr = [i+1 for i in range(N)]
    target = list(map(int, input().split()))

    if target == arr :
        print(-1)

    else:
        min_value = 99;
        for i in range(N-1,-1,-1):
            if target[i] < target[i-1]:
                idx1 = i-1
                for j in range(i+1,N):
                    min_value = min(min_value,abs(target[idx1]-target[j]))
                idx2 = j
                break
        swap(target,idx1,idx2)
        answer = target[:idx1+1]
        sorting_arr = target[idx1+1:]
        sorting_arr = sorted(sorting_arr, reverse=True)
        answer = answer+sorting_arr

        for i in answer:
            print(i, end=" ")

def swap(target,a, b):

    tmp = target[a]
    target[a] = target[b]
    target[b] = tmp

if __name__=="__main__":
    main()