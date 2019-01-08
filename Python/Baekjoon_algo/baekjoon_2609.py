#GCD LCM
def main():
    x, y = map(int, input().split())

    print(GCD(x,y))
    print(LCM(x,y))

def GCD(a, b):
    while (b!=0):
        temp = a % b
        a = b
        b= temp

    return abs(a)

def LCM(a, b):
    return int(a * b / GCD(a,b))

if __name__ == "__main__" :
    main()