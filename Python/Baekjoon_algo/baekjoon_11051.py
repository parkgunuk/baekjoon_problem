#이항계수 점화식(파스칼의 법칙)
#  n        n        n+1
#(   ) + (     ) = (     )
#  k       k+1       k+1

def main():
    N,K = map(int, input().split())

    print((factorial(N))//(factorial(K)*factorial(N-K))%10007)


def factorial(n):
    answer = [1]
    for i in range(1,n+1):
        answer.append(answer[i-1]*i)

    return answer[n]
if __name__=="__main__":
    main()