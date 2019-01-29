def main():
    N = int(input())
    ans = [1 for _ in range(N)]
    A = list(map(int, input().split()))

    for i in range(N):
        for j in range(i, -1, -1):
            if ans[j] < ans[i] and A[j] >= A[i]:
                A[i] = A[j] + 1

if __name__=="__main__":
    main()