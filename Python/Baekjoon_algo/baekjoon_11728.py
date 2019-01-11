#정수형으로 받으면 안된다. why?

def main():
    N, M =  map(int, input().split())

    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    C = A+B
    C = sorted(C)

    for i in range(len(C)):
        print(C[i],end=" ")

if __name__=="__main__":
    main()

