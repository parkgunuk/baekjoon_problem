#input 보다 sys.stdin.readline.split이 빠르다.

import sys

def main():
    a = int(input())
    arr = [0] * 21
    for i in range(0, a):
        op = sys.stdin.readline().split()
        if op[0] == "all":
            arr = [1] * 21
        elif op[0] == "empty":
            arr = [0] * 21
        else:

            if op[0] == 'add':
                num = int(op[1])
                arr[num] = 1
            elif op[0] == 'remove':
                num = int(op[1])
                arr[num] = 0
            elif op[0] == 'check':
                num = int(op[1])
                print(arr[num])
            elif op[0] == 'toggle':
                num = int(op[1])
                arr[num] = (arr[num] + 1) % 2

if __name__=="__main__":
    main()