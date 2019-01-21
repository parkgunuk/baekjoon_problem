#BFS로 문제를 풀어보자
#make queue

'''

4 6
101111
101010
101011
111011

'''
#TODO

cnt = []

def main():

    # N = row M = col , 도착지 (N-1,M-1)
    N,M = map(int, input().split())

    map_list = [[0 for _ in range(M)] for _ in range(N)]
    visited = [[0 for _ in range(M)] for _ in range(N)]
    arr = []

    for _ in range(N):
        arr.append(list(input()))

    for row in range(N):
        for col in range(M):
            map_list[row][col] = int(arr[row][col])

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    queue = []
    queue.append((0, 0))
    visited[0][0] =1

    while queue:
        r,c = queue.pop(0)
        if r == N - 1 and c == M - 1:
            print(visited[r][c])
            break
        for i in range(4):
            next_r = r + dx[i]
            next_c = c + dy[i]

            if next_r >= 0 and next_r < N and next_c >=0 and next_c < M:
                if visited[next_r][next_c] == 0 and map_list[next_r][next_c] == 1:
                    visited[next_r][next_c] = visited[r][c] + 1
                    queue.append(((next_r, next_c)))
if __name__=="__main__":
    main()