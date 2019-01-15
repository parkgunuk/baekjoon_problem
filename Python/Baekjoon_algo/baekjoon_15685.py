def main():

    case = int(input())
    setting = []
    arr = []
    cnt = 0
    for _ in range(case):
        col_x, row_y, d, g = map(int, input().split())

        arr.append([row_y, col_x])

        dragon = [[d]]
        #드래곤 커브 방향 설정
        for i in range(1, g+1):
            tmp = []

            #print(dragon)
            for j in range(len(dragon[i-1])):
                tmp.append(dragon[i-1][j])
            for j in range(len(dragon[i-1]), 0, -1):
                tmp.append((dragon[i-1][j-1] + 1)%4)

            dragon.append(list(tmp))

        # 선분 방향 설정
        dir = [[1, 0], [0, -1], [-1, 0], [0, 1]] # 우(0), 상(1), 좌(2), 하(3) (col,row)

        nextX = col_x;  #col
        nextY = row_y;  #row
        if[nextY,nextX] not in setting:
            setting.append([nextY,nextX])

        for i in dragon[g]:

            nextX = nextX + dir[i][0]
            nextY = nextY + dir[i][1]
            if [nextY,nextX] in setting:
                continue
            else:
                setting.append([nextY,nextX])

        setting = sorted(setting)

    boxCheck = [[0, 1], [1, 0], [1, 1]]  # 박스 이루는지 체크

    for i in range(len(setting)):
        count = 0
        for j in range(len(boxCheck)):
            next_row = setting[i][0]+boxCheck[j][0]
            next_col = setting[i][1]+boxCheck[j][1]

            if [next_row, next_col] in setting:
                count+=1

        if count == 3:
            cnt+=1

    print(cnt)
if __name__=="__main__":
    main()