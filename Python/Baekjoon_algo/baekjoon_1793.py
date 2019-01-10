#정답은 맞는데 런타임오류...

def main():
    while(True):
        N = int(input())
        dp = [1,1,3,5]

        for i in range(len(dp), N+1):
            dp.append(dp[i-1]+dp[i-2]*2)

        print(dp[N])

if __name__=="__main__":
    main()