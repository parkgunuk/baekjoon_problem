#재귀적으로 풀어야한다니..

import sys

sys.setrecursionlimit(10**6)
RGB = []
def main():
    N = int(input())
    for i in range(N):

        RGB.append(list(map(int, input().split())))

    print(min(dp(N-1)))

def dp(lev):
    if lev ==-1:
        return [0,0,0]
    cache = dp(lev-1)
    RGB[lev][0] += min(cache[1], cache[2])
    RGB[lev][1] += min(cache[0], cache[2])
    RGB[lev][2] += min(cache[0], cache[1])
    return RGB[lev]

if __name__=="__main__":
    main()