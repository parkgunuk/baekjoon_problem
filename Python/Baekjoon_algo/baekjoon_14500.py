#16:13
#18:00

#9:19
#12:03 맞춤

d = [[0,1],[0,-1],[1,0],[-1,0]]
max_num = 0;

def main():
    N,M = map(int, input().split())
    mapping = []
    visited = [[False] * M for _ in range(N)]

    for _ in range(N):
        mapping.append(list(map(int, input().split())))

    #DFS
    for r in range(N):
        for c in range(M):
            DFS(mapping, visited, N, M, 0, r, c, 1)
            visited[r][c] = False
            CheckOther(mapping, N, M, r, c)
    print(max_num)

def DFS(mapping, visited, N, M, sum_num, row, col, cnt):
    global max_num

    visited[row][col] = 1
    sum_num += mapping[row][col]
    if cnt == 4:
        max_num = max(max_num, sum_num)
        return;

    for i in range(4):
        next_r = row + d[i][0]
        next_c = col + d[i][1]

        if 0 <= next_r < N and 0 <= next_c < M and visited[next_r][next_c] != 1:
            DFS(mapping, visited, N, M, sum_num, next_r, next_c, cnt+1)
            visited[next_r][next_c] = False

def CheckOther(mapping, N, M, r, c):
    global max_num

    sol1 = 0
    sol2 = 0
    sol3 = 0
    sol4 = 0

    if r+1 < N and c + 1< M and c - 1 >= 0 :
        sol1 = max(sol1, mapping[r][c]+mapping[r+1][c]+mapping[r][c+1]+mapping[r][c-1])
    if r+1 < N and r - 1 >= 0 and c - 1 >= 0 :
        sol2 = max(sol2, mapping[r][c]+mapping[r+1][c]+mapping[r-1][c]+mapping[r][c-1])
    if r-1 >= 0 and r + 1< N and c + 1 < M :
        sol3 = max(sol3, mapping[r][c]+mapping[r-1][c]+mapping[r+1][c]+mapping[r][c+1])
    if c-1 >= 0 and c + 1< M and r - 1 >= 0 :
        sol4 = max(sol4, mapping[r][c]+mapping[r][c-1]+mapping[r][c+1]+mapping[r-1][c])


    max_num = max(max_num, sol1,sol2,sol3,sol4)

if __name__ == "__main__":
    main()