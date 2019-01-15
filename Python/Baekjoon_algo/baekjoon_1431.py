#TODO

def main():
    N = int(input())

    arr = []
    arr_len =[]

    answer=[]

    for _ in range(N):
        k = list(input())

        arr.append(k)
        arr_len.append(len(k))

    print(arr)
    print(arr_len)

    for _ in range(N):

        idx = arr_len.index(min(arr_len))
        answer.append(arr[idx])
        arr_len.pop(idx)
        arr.pop(idx)

    arr = answer[:]

    print(answer)


if __name__=="__main__":
    main()