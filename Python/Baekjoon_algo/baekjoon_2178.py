#BFS로 문제를 풀어보자

def main():

    # N = row M = col , 도착지 (N-1,M-1)
    N,M = map(int, input().split())

    map_list = [[0 for _ in range(M+2)] for _ in range(N+2)]
    visited = [[False for _ in range(M)] for _ in range(N)]
    arr = []
    cnt = 0

    for _ in range(N):
        arr.append(list(input()))

    for row in range(1,N+1):
        for col in range(1,M+1):
            map_list[row][col] = int(arr[row-1][col-1])


def BFS():
if __name__=="__main__":
    main()