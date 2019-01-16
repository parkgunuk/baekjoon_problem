#브루트 포스

def main():
    arr = []

    for _ in range(9):
        arr.append(int(input()))

    arr = sorted(arr, reverse=True)

    for i in sorted(brute(arr)):
        print(i)

def brute(arr):
    for i in range(9):
        arr_ = arr[:]
        arr_.pop(i)
        for j in range(len(arr_)):
            arr__ = arr_[:]
            arr__.pop(j)
            if sum(arr__) == 100:
                return arr__
if __name__=="__main__":
    main()