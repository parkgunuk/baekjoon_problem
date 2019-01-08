#정렬은 very easy

def main():
    N = int(input())
    arr = []

    for i in range(N):
        num = int(input())
        arr.append(num)

    arr = sorted(arr)

    for i in range(N):
        print(arr[i])
if __name__ =="__main__":
    main()