# 범위가 엄청 크기 떄문에 이진탐색

def main():
    N, M = map(int, input().split())
    play = list(map(int, input().split()))

    l = 1
    r = 10 ** 20
    max_m = max_s = 0

    while l <= r:
        mid = (l + r) // 2
        s = sum((mid - 1) // x + 1 for x in play)
        if s < N:
            if max_m < mid:
                max_m = mid
                max_s = s
            l = mid + 1
        else:
            r = mid - 1

    for idx, k in enumerate(play):
        if max_m % k == 0:
            max_s += 1
            if max_s == N:
                print(idx + 1)
                break

if __name__=="__main__":
    main()