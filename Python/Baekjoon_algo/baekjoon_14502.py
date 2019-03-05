
#
import copy

maxValue = 0
d = [[1,0], [-1,0], [0,1], [0,-1]]
arr = []

def main():
    N,M = map(int, input().split())

    lab = []

    for _ in range(N):
        lab.append(list(map(int, input().split())))

    visited = [[False]*M for _ in range(N)]

    for r in range(N):
        for c in range(M):
            go(lab, visited, N, M, r, c, 0)

    print(maxValue)

def go(lab, visited, N, M, r, c, cnt):
    global arr

    if cnt == 3:
        arr_ = copy.deepcopy(arr)
        arr_ = sorted(arr_)
        string = makeStr(arr_)
        if string not in visit:
            visit.append(string)
            doVirus(lab, N, M)
        return
    # for i in range(r,N):
    #     for j in range(c,M):
    #         next_r = i
    #         next_c = j
    #
    #         if 0<=next_r<N and 0<=next_c<M and visited[next_r][next_c] == False and lab[next_r][next_c] == 0:
    #             visited[next_r][next_c] = 1
    #             lab[next_r][next_c] = 1
    #             arr.append([next_r,next_c])
    #             go(lab, visited, N, M, r, c, cnt+1)
    #             arr.pop()
    #             lab[next_r][next_c] = 0
    #             visited[next_r][next_c] = False

def doVirus(lab, N, M):
    global maxValue
    lab_ = copy.deepcopy(lab)
    #BFS
    queue = []
    for r in range(N):
        for c in range(M):
            if lab_[r][c] == 2:
                queue.append([r,c])

    while True:
        if len(queue) == 0:
            break;
        xy = queue.pop(0)

        rr = xy[0]
        cc = xy[1]

        for i in range(4):
            nr = rr + d[i][0]
            nc = cc + d[i][1]

            if 0<=nr<N and 0<=nc<M and lab_[nr][nc] == 0:
                lab_[nr][nc] = 2
                queue.append([nr,nc])
    # print(cntZero(lab_))
    maxValue = max(maxValue, cntZero(lab_))

def cntZero(lab):
    cnt=0
    for i in range(len(lab)):
        for j in range(len(lab[0])):
            if lab[i][j] == 0:
                cnt+=1

    return cnt

def makeStr(arr):
    string = ""

    for i in arr:
        for j in i:
            string+=str(j)

    return string
if __name__ == "__main__":
    main()