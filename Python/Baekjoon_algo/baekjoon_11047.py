#time out -> PyPy3 로 컴파일
# grid algo


def main():
    N,K = map(int, input().split())

    money = []
    cnt = 0

    for _ in range(N):
        money.append(int(input()))


    for i in range(N-1, -1,-1):
        while(K >= money[i]):
            K -= money[i]
            cnt += 1
        if K < 0:
            break
    print(cnt)
if __name__=="__main__":
    main()