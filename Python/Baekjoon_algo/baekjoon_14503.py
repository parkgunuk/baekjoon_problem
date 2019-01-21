#왜 잘 되는 것일까 잘 모르겠다..

import sys
sys.setrecursionlimit(10**6)

def main():

    row, col = map(int, input().split())
    r,c,d = map(int, input().split())
    map_ = []

    for _ in range(row):
        map_.append(list(map(int, input().split())))

    print(clean(map_, r, c, d))

def clean(m, r, c, N, j=1):
    dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    if m[r][c] == 0:
        m[r][c] = 2
    for i in range(1, 5):
        next_r,next_c = r + dir[N - i][0],c + dir[N - i][1]
        if m[next_r][next_c] == 0:
            ans=(N-i+4)%4
            return clean(m, next_r, next_c, ans, j + 1)
    next_r,next_c = r + dir[N - 2][0],c + dir[N - 2][1]
    if m[next_r][next_c]==1: return j
    return clean(m, next_r, next_c, N, j)

if __name__ == "__main__":
    main()