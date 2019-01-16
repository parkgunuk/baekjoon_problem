def main():
    N = int(input())
    city = list(map(int, input().split()))
    M = int(input())
    money = []

    if sum(city) < M:
        print(max(city))

    elif min(city) >= M//N:
        print(M//N)

    else:
        start_m = M // N
        end_m = max(city)
        while end_m - start_m >= 0:
            sum_m = 0
            mid_m = (start_m + end_m)//2
            for i in city:
                if i < mid_m:
                    sum_m+=i
                else:
                    sum_m+=mid_m

            if sum_m <= M: #오른쪽으로
                money.append(mid_m)
                start_m = mid_m+1
            else: #왼쪽으로
                end_m = mid_m-1
        #print(money)
        print(max(money))

if __name__=="__main__":
    main()