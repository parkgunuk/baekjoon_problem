def main():
    N = int(input())
    ans = [1 for _ in range(N)]
    A = list(map(int, input().split()))

    for i in range(N):
        for j in range(i, -1, -1):
            if A[j] > A[i] and ans[j] >= ans[i]:
                ans[i] = ans[j] + 1

    print(max(ans))
if __name__=="__main__":
    main()