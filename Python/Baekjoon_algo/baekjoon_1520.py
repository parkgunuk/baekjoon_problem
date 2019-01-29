import sys
sys.setrecursionlimit(10**6)

def main():
    row,col = map(int, input().split())

    pam = []
    visited = [[-1 for _ in range(col)] for _ in range(row)]
    for _ in range(row):
        pam.append(list(map(int, input().split())))


    print(finding(pam, visited, row, col, row-1, col-1))

def finding(pam, visited, row, col, r, c):
    dir = [[-1,0],[0,-1],[0,1],[1,0]]

    if r == 0 and c == 0:
        return 1

    if visited[r][c] == -1:
        visited[r][c] = 0;
        for i in range(4):
            next_r = r + dir[i][0]
            next_c = c + dir[i][1]
            if 0<=next_r<row and 0<=next_c<col:
                if pam[r][c] < pam[next_r][next_c] :
                    visited[r][c] += finding(pam, visited, row, col, next_r, next_c)

    return visited[r][c]
if __name__=="__main__":
    main()