
'''

7
6
1 2
2 3
1 5
5 2
5 6
4 7

'''

def main():
    N = int(input())
    case = int(input())
    arr = []
    warm = [1]
    for i in range(case):
        x,y = map(int, input().split())
        arr.append([x,y])

    for i in range(case):
        if arr[i][0] in warm and arr[i][1] not in warm:
            warm.append(arr[i][1])

        elif arr[i][1] in warm and arr[i][0] not in warm:
            warm.append(arr[i][0])


    for i in range(case-1, -1, -1):
        if arr[i][1] in warm and arr[i][0] not in warm:
            warm.append(arr[i][0])

        elif arr[i][0] in warm and arr[i][1] not in warm:
            warm.append(arr[i][1])

    #print(warm)
    print(warm)
    print(len(warm)-1)
if __name__=="__main__":
    main()


# 반례가 필요합니다.... 뭘까요.....