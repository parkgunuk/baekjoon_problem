#Remind

import sys
import collections

N = 0
arr = []
## 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
snakes = collections.deque([[1, 1]])


def printX():
    print()
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            print(arr[i][j], end=" ")
        print()


def snake_move(direction):
    [x, y] = snakes[0]

    nx = x + dx[direction]
    ny = y + dy[direction]

    ## 머리가 몸통에 부딪히면 종료
    if [nx, ny] in snakes:
        return True

    ## 벽에 부딪히면 종료
    if nx <= 0 or nx > N or ny <= 0 or ny > N:
        return True

    ## 이동한 칸에 아무것도 없으면 꼬리를 줄여줌
    if arr[nx][ny] == 0:
        [ex, ey] = snakes.pop()
        arr[ex][ey] = 0

    ## 이동한 칸에 사과가 있으면 없애고 몸을 늘린다
    snakes.appendleft([nx, ny])
    arr[nx][ny] = 1

    return False


def rotate(s, d):
    ## L이면 왼쪽 D면 오른쪽
    if s == "L":
        return (d + 3) % 4
    else:
        return (d + 1) % 4


def solve(move, L):
    idx = 0
    direction = 1  ## 초기 방향은 오른쪽
    time = 0

    while True:
        if idx < L:
            if move[idx][0] == time:
                direction = rotate(move[idx][1], direction)
                idx += 1

        if snake_move(direction) == True:
            print(time + 1)
            return

        time += 1


if __name__ == '__main__':
    N = int(sys.stdin.readline())
    K = int(sys.stdin.readline())
    arr = [[0] * (N + 1) for i in range(N + 1)]

    for i in range(K):
        v1, v2 = map(int, sys.stdin.readline().split())
        arr[v1][v2] = 2

    L = int(sys.stdin.readline())

    move = []
    for i in range(L):
        X, C = sys.stdin.readline().split()
        move.append([int(X), C])

    ## 처음 뱀 위치
    arr[1][1] = 1
    solve(move, L)
