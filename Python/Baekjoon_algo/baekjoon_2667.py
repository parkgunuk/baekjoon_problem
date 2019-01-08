#DFS 로 문제를 푼다
import sys
sys.setrecursionlimit(1000000000) # DFS 할떄는 필수

def main():
    N = int(input())
    map = []
    visited = [[False]*N for _ in range(N)]
    count = []

    for _ in range(N):
        arr = list(input())
        map.append(arr)


    cnt = 0;
    for row in range(N):
        for col in range(N):
            if map[row][col] == '1' and visited[row][col] == False:
                cnt+=1
                DFS(map, visited, N, cnt, row, col)
    print(cnt)
    for i in range(1, cnt+1):
        danzi = 0;
        for j in range(N):
            danzi += visited[j].count(i)
        count.append(danzi)
    count = sorted(count)
    for i in count:
        print(i)
def DFS(map, visited, N, cnt, row, col):
    x_dir = [1,-1,0,0]
    y_dir = [0,0,1,-1]
    visited[row][col] = cnt

    for i in range(4):
        next_col = col+x_dir[i]
        next_row = row+y_dir[i]

        if 0 <= next_col < N and 0<= next_row <N :
            if map[next_row][next_col] == '1' and visited[next_row][next_col] == False :
                DFS(map, visited, N, cnt, next_row, next_col)

if __name__=="__main__":
    main()