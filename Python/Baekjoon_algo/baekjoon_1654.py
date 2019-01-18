def main():
    K, N = map(int, input().split())
    arr= []

    for _ in range(K):
        arr.append(int(input()))

    arr = sorted(arr)
    start = 0;
    end = (2**32)
    ans = 0

    while end >= start:
        mid = (start+end)//2
        cnt = 0

        for i in arr:
            cnt+=(i//mid)

        if cnt < N:
            end = mid-1
        else:
            start = mid +1
            ans = max(mid, ans)

    print(ans)
if __name__=="__main__":
    main()