#sys.stdin.readline() <- 개행문자까지 읽기

import sys

def main():
    dp = [1]*251
    dp[1] = 1
    dp[2] = 3

    for i in range(3, 251):
        dp[i] = (dp[i-1]+dp[i-2]*2)

    while True:
        input_ = sys.stdin.readline()
        if input_ == '':
            break
        N = int(input_)
        print(dp[N])

if __name__=="__main__":
    main()