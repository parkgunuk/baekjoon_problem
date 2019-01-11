import itertools

def main():
    N, M = map(int, input().split())

    arr = [str(i+1) for i in range(N)]

    answer = list(map(' '.join, itertools.product(arr,repeat = M)))

    for ans in answer:
        print(ans)
if __name__=="__main__":
    main()