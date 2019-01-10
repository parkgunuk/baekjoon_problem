def GCD(a, b):
    while (b!=0):
        temp = a % b
        a = b
        b= temp

    return abs(a)

def main():
    T = int(input())

    for _ in range(T):
        sum = 0;
        arr = list(map(int, input().split()))

        for i in range(1,len(arr)):
            for j in range(i+1, len(arr)):
                sum+=GCD(arr[i], arr[j])

        print(sum)
if __name__=="__main__":
    main()