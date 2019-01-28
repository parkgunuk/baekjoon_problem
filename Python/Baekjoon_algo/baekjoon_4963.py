
def main():
    while(True):
        col, row = map(int, input().split())
        if row == 0 and col == 0:
            break
        arr = []
        visited = [[False for _ in range(col)] for _ in range(row)]
        ans = 0
        for _ in range(row):
            arr.append(list(map(int, input().split())))

        for r in range(row):
            for c in range(col):
                if(arr[r][c] == 1 and visited[r][c] == False):
                    ans+=1
                    DFS(arr, visited, row, col, r,c)
        print(ans)
def DFS(arr, visited, row, col, r, c):
    dir = [[-1,-1],[-1,0],[-1,0],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
    visited[r][c] = 1

    for i in range(8):
        next_r = r + dir[i][0]
        next_c = c + dir[i][1]

        if(0<= next_r< r and 0<= next_c< c ):
            if (arr[next_r][next_c] == 1 and visited[next_r][next_c] == False):
                DFS(arr,visited,row,col,r,c)

if __name__=="__main__":
    main()