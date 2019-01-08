#소수 찾기

def main():

    N = input()

    numbers = input().split()
    cnt = 0

    for i in numbers:
        idx = 0
        i = int(i)
        for j in range(1,i+1):
            if i%j==0:
                idx +=1
        if idx == 2:
            cnt +=1
    print(cnt)
if __name__=="__main__":
    main()