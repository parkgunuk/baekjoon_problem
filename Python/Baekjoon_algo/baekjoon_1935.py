#postfix -> infix

operator = ['*', '/', '+', '-']
bracket = ['(', ')']

def main():
    N = int(input())
    postfix = list(input())
    infix = []
    number = []
    stack = []

    for i in range(N):
        number.append(int(input()))

    for c in postfix:
        if is_num(c):
            stack.append(c)
        elif
    print(postfix)
    print(arr)

def is_num(x):
    if x not in operator and x not in bracket:
        return True
    else:
        return False

if __name__=="__main__":
    main()