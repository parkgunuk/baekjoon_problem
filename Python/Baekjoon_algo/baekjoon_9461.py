#규칙을 찾는 DP 문제

def main():
    T = int(input())

    for case in range(T):
        num = int(input())

        dp = [1]*(num)

        if num >= 4:
            dp[3]=2
            if num >=5:
                dp[4]=2

                for i in range(5,num):
                    dp[i] = dp[i-1]+dp[i-5]

        print(dp[num-1])

if __name__=="__main__":
    main()