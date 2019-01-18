
def main():
    N,M = map(int, input().split())
    arr = list(map(int, input().split()))

    arr = sorted(arr)

    start_height = 0
    end_height = arr[-1]

    while end_height >= start_height :
        mid = (end_height+start_height)//2
        sum = 0

        for i in arr:
            if mid < i:
                sum += (i - mid)

        if sum >= M:
            start_height = mid +1
        elif sum <= M:
            end_height = mid -1

    print(end_height)

if __name__=="__main__":
    main()