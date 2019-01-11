#메모리 초과
#TODO
import itertools

def main():
    N = int(input())
    arr = [str(i+1) for i in range(N)]
    target = input().split()
    target = ''.join(target)

    answer = list(map(''.join, itertools.permutations(arr)))

    if answer[0] == target:
        print(-1)
    else:
        print(answer[answer.index(target)-1])

if __name__=="__main__":
    main()