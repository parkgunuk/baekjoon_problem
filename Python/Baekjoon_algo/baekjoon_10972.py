#다음 순열 -> DFS 로 문제를 풀어보자
#직접
import time
#TODO

def main():

    N = int(input())

    num = input().split()
    print(num)
    number = ''.join(num)

    visited = [False for _ in range(N+1)]

    numbers = [0 for _ in range(N)]

    arr =[]
    permutation(0, numbers, visited,N,arr)

    if arr[-1] == number:
        print(-1)
    else :
        print(' '.join(list(arr[arr.index(number) + 1])))

def permutation(idx,numbers,visited,N,arr):

    if idx == N:
        arr.append(''.join(numbers))
        return

    for i in range(1,N+1):

        if visited[i] == False:
            numbers[idx] = str(i)
            visited[i] = True
            permutation(idx+1,numbers,visited,N,arr)
            visited[i] = False

if __name__ == "__main__":
    main()