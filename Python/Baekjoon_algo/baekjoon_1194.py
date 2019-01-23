def main():
    row, col = map(int, input().split())
    possible = [[[0]*64 for _ in range(col)] for _ in range(row)]
    map_ = []

    dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    queue = []
    key = []
    flag = 0

    for _ in range(row):
        map_.append(list(input()))

    for r in range(row):
        for c in range(col):
            if map_[r][c] == '0':
                queue.append([r, c, 0])

    while len(queue) != 0 and flag == 0:
        # 1. queue에서 빼준다
        # 2. queue에서 뺀 값이 가능한 경우를 queue에 넣어준다.
        # 3. 다음 queue로 넘어간다.

        qu = queue.pop(0)
        rr = qu[0]
        cc = qu[1]
        kk = qu[2]

        if 'a'<=map_[rr][cc]<='f':
            possible[rr][cc] = 1

        if 'A'<=map_[rr][cc]<='F' :
            if map_[rr][cc] in key:
                possible[rr][cc] = 1
                continue

        if map_[rr][cc] == '1':
            print(possible[rr][cc][kk])
            flag = 1
            break

        for i in range(4):
            next_r = rr + dir[i][0]
            next_c = cc + dir[i][1]
            next_k = kk

            c = map_[next_r][next_c]

            if next_r < 0 or next_r >= row or next_c < 0 or next_c >= col :
                continue

            if c.islower():
                next_k |= (1 << (ord(c) - ord('a')))
            elif c.isupper() and not next_k & (1 << (ord(c) - ord('A'))):
                continue

            if not possible[next_r][next_c][next_k] and c != '#':
                queue.append([next_r, next_c, next_k])
                possible[next_r][next_c][next_k] = possible[rr][cc][kk] + 1

    if flag == 0 :
        print(-1)
if __name__=="__main__":
    main()