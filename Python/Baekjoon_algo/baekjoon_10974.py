import itertools

def main():
    N = int(input())

    arr = [str(i+1) for i in range(N)]

    answer = list(map(' '.join, itertools.permutations(arr)))

    for ans in answer:
        print(ans)
if __name__=="__main__":
    main()