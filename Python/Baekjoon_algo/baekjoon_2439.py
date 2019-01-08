#별찍기

def main():
    N = int(input())

    for i in range(1,N+1):
        arr = []
        for j in range(N-i):
            arr.append(' ')
        for k in range(i):
            arr.append('*')
        print(''.join(arr))

if __name__ == "__main__":
    main()