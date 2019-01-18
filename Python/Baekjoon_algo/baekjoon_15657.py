answer = []
def main():
    N,M = map(int, input().split())

    arr = list(map(int, input().split()))
    arr = sorted(arr)

    combination(arr, 0, M)

def combination(arr, idx, M):
    if idx == M:
        if check(answer)==1:
            for index in range(M):
                print(answer[index], end=' ')
            print()
        return
    for i in range(len(arr)):
        answer.append(arr[i])
        combination(arr, idx+1,M)
        answer.pop()
def check(arr):
    for i in range(len(arr)-1):
        if arr[i] > arr[i+1]:
            return 0
    return 1
if __name__=="__main__":
    main()