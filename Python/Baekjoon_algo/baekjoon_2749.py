#피사노 주기를 사용하면 된다.
# 문제의 1,000,000 으로 나눈 나머지에 관심을 가지면 된다.

def main():
    n = int(input())

    fibo = [0, 1]
    mod = 1000000
    p = int(mod / 10 * 15)
    i = 2
    while i < p:
        fibo.append(fibo[i - 1] + fibo[i - 2])
        fibo[i] %= mod
        i += 1

    print(fibo[n % p])


if __name__ == '__main__':
    main()