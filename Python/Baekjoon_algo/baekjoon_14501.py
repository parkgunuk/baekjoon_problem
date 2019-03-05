#TODO
max_sum = 0

def main():

    N = int(input())

    schedule =[]
    dp =[]

    for _ in range(N):
        schedule.append(list(map(int,input().split())))

    for i in range(len(schedule)):
        go(schedule, N, i, 0)

    print(max_sum)
def go(arr, N):
    global max_sum
    index =idx + arr[idx][0]
    if index < N:
        go(arr, N, index , sum + arr[idx][1])
    else :
        if arr[-1][0]==1
        max_sum = max(max_sum, sum)
        return


if __name__ == "__main__":
    main()
