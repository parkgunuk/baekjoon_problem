#13:47
#14:27

def main():
    N = int(input())
    a = list(map(int, input().split()))
    B,C = map(int, input().split())

    ans = len(a)

    for idx, val in enumerate(a):
        if val <= B:
            a[idx] = 0
        else :
            a[idx] = val -B

    for idx, val in enumerate(a):
        if 0< val < C :
            ans+=1
            a[idx] = 0
        else:
            if val%C == 0:
                ans = ans + a[idx]//C
            else:
                ans = ans + a[idx]//C + 1

    print(ans)
if __name__ == "__main__":
    main()