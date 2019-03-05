def main():
    while(True):
        N = int(input())
        if N == 0:
            break
        arr = []
        visited = [[False for _ in range(N)] for _ in range(N)]
        weight = [[0 for _ in range(N)] for _ in range(N)]
        for i in range(N):
            arr.append(list(map(int, input().split())))
        weight[0][0] = arr[0][0]
        go(arr, weight, visited, N, (N-1)*2 , 0, 0, arr[0][0])

def go(arr, weight, visited, N, maximum, row, col, value):
    dir = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    visited[row][col] = True
    for i in range(4):
        nr = row + dir[i][0]
        nc = col + dir[i][0]
        if 0 <= nr < N and 0 <= nc < N :
            if visited[nr][nc] == False :


if __name__ == "__main__":
    main()