def main():
    T = int(input())
    dp = [1,2,4]
    for number in range(T):
        number = int(input())

        for i in range(len(dp), number):
            dp.append(dp[i-1]+dp[i-2]+dp[i-3])

        print(dp[number-1])
if __name__=="__main__":
    main()