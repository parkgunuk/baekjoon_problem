#TODO

def main():
    N = int(input())

    arr = []
    arr_len =[]

    answer=[]
    min_len = 52

    for _ in range(N):
        k = list(input())

        arr.append(k)
        arr_len.append(len(k))

    for _ in range(N):
        i = arr.pop(arr_len.index(min(arr_len)))
        answer.append(i)

    print(answer)
if __name__=="__main__":
    main()