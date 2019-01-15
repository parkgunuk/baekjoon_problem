#정수형으로만 받아야 한다. why? -> sort할때 숫자값으로 비교해야 하기 때문이다

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

