#14:52
#16:07
def main():
    N,M,x,y,K = map(int,input().split())    # N = row , M = col , x = row , y = col
    mapping = []
    dice = [[0]*3 for _ in range(4)]

    for _ in range(N):
        mapping.append(list(map(int, input().split())))

    order = list(map(int, input().split()))
    ans = []
    for val in order:
        if val == 1:
            if 0<=y+1<M:
                east(dice)
                y += 1
                newMap(mapping, dice, x, y)
                ans.append(dice[1][1])
        elif val == 2:
            if 0<=y-1<M:
                west(dice)
                y -= 1
                newMap(mapping, dice, x, y)
                ans.append(dice[1][1])
        elif val == 3:
            if 0<=x-1<N:
                north(dice)
                x -= 1
                newMap(mapping, dice, x, y)
                ans.append(dice[1][1])
        elif val == 4:
            if 0<=x+1<N:
                south(dice)
                x += 1
                newMap(mapping, dice, x, y)
                ans.append(dice[1][1])
    for answer in ans:
        print(answer)

def newMap(mapping, dice, x, y):
    if mapping[x][y] == 0:
        mapping[x][y] = dice[3][1]
    else:
        dice[3][1] = mapping[x][y]
        mapping[x][y] = 0

def east(dice):
    tmp = dice[1][1]
    dice[1][1] = dice[1][0]
    dice[1][0] = dice[3][1]
    dice[3][1] = dice[1][2]
    dice[1][2] = tmp

def west(dice):
    tmp = dice[1][1]
    dice[1][1] = dice[1][2]
    dice[1][2] = dice[3][1]
    dice[3][1] = dice[1][0]
    dice[1][0] = tmp

def north(dice):
    tmp = dice[1][1]
    dice[1][1] = dice[2][1]
    dice[2][1] = dice[3][1]
    dice[3][1] = dice[0][1]
    dice[0][1] = tmp

def south(dice):
    tmp = dice[1][1]
    dice[1][1] = dice[0][1]
    dice[0][1] = dice[3][1]
    dice[3][1] = dice[2][1]
    dice[2][1] = tmp

if __name__ == "__main__":
    main()