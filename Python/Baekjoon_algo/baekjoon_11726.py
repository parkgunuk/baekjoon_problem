import time

def main():
    N = int(input())
    answer = [0,1,2]
    for i in range(3,N+1):
        answer.append((answer[i-1]+answer[i-2])%10007)

    print(answer[N])

if __name__=="__main__":
    start_time = time.time()
    main()
    end_time = time.time()

    print(end_time - start_time)

'''
위 소스는 정답 아래 소스는 런타임 에러
런타임 에러가 왜 나는 걸까요???

def main():
    N = int(input())
    answer = [0]*(N+1)
    
    answer[1] = 1
    answer[2] = 2
    
    for i in range(3,N+1):
        answer[i] = (answer[i-1]+answer[i-2])%10007

    print(answer[N])
    
if __name__=="__main__":

    main()

'''