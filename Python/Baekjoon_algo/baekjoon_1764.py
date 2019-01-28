import sys

def main():
    read = sys.stdin.readline
    write = sys.stdout.write

    N, M = map(int, input().split())

    no_listen = set()
    answer = set()

    for _ in range(N):
        no_listen.add(read())

    for _ in range(M):
        tmp = read()
        if tmp in no_listen: answer.add(tmp)

    answer = list(answer)
    answer.sort()

    print(len(answer))
    for a in answer:
        write(a)

if __name__=="__main__":
    main()