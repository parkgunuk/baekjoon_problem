#   TomaTo Probleam
#   BFS는 queue를 구현해서 만들어야 한다.

def main():
    #   M은 상자의 가로(col), N은 상자의 세로(row)


    M,N = map(int, input().split())

    box = [list(map(int, input().split())) for i in range(N)]

    days = 0
    queue = []

    for i in range(N):
        for j in range(M):
            if box[i][j] == 1:
                queue.append((j,i))

    while True:
        box, queue = BFS(box, queue, N, M)

        if queue == []:
            break;

        days +=1

    for i in range(N):
        for j in range(M):
            if box[i][j] == 0:
                days = -1
    print(days)

def BFS(box, queue, N,M):
    dir = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    after_map = []

    for location in queue:
        for direction in dir:
            newX = location[0]+direction[0]
            newY = location[1]+direction[1]

            if (0 <=newX< M) and (0<=newY<N) :
                if box[newY][newX] == 0:
                    after_map.append((newX,newY))
                    box[newY][newX] = 1

    return box, after_map

if __name__ =='__main__':
    main()