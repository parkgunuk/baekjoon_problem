#팩토리얼 dp를 써보자

def main():

    N = int(input())
    DP = [1]*(N+1)

    for i in range(2,N+1):
        DP[i] = DP[i-1] * i

    print(DP[N])


if __name__ == "__main__":
    main()