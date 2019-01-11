#DFS -2667 단지번호 붙이기와 비슷
'''

2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

'''

#TODO

import sys
sys.setrecursionlimit(10**6)

def main():
    T = int(input())
    for test_case in range(1,T+1):
        M,N,K = map(int, input().split())

        farm_map = [[0 for _ in range(M)] for _ in range(N)]
        visited = [[False for _ in range(M)] for _ in range(N)]

        for _ in range(K):
            col,row = map(int, input().split())
            farm_map[row][col] = 1


        cnt = 0;
        for row in range(N):
            for col in range(M):
                if farm_map[row][col] == 1 and visited[row][col] == False:
                    cnt += 1
                    bug(farm_map, visited, N, M, cnt, row, col)
        print(cnt)
def bug(maping,visited,N,M,cnt,row,col):
    dir_x = [1,-1,0,0]
    dir_y = [0,0,1,-1]
    visited[row][col] = True

    for i in range(4):
        next_row = row+dir_x[i]
        next_col = col+dir_y[i]

        if 0<=next_row< N and 0<=next_col<M and maping[next_row][next_col] == 1:
            if maping[next_row][next_col] == 1 and visited[next_row][next_col] == False :
                bug(maping, visited, N,M, cnt, next_row, next_col)

if __name__=="__main__":
    main()