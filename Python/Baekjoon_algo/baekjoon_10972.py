def main():
    N = int(input())
    arr = [i+1 for i in range(N-1,-1,-1)]
    target = list(map(int, input().split()))
    select = []

    if target == arr :
        print(-1)

    else:
        for i in range(N-1,0,-1):
            if target[i]>target[i-1]:
                idx = i;
                break
        for j in range(idx,N):
            if(target[idx-1]<target[j]):
                select.append(target[j])
        idx2 = target.index(min(select))

        swap(target,idx-1,idx2)
        answer = target[:idx]
        sorting = target[idx:]
        sorting = sorted(sorting)
        answer += sorting

        for i in answer:
            print(i, end=" ")

def swap(target,a, b):

    tmp = target[a]
    target[a] = target[b]
    target[b] = tmp

if __name__=="__main__":
    main()