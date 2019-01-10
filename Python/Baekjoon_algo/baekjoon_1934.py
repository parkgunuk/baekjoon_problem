def GCD(a, b):
    while (b!=0):
        temp = a % b
        a = b
        b= temp

    return abs(a)

def LCM(a, b):
    return int(a * b / GCD(a,b))

def main():
    T = int(input())

    for _ in range(T):
        x, y = map(int, input().split())
        print(LCM(x,y))
if __name__=="__main__":
    main()