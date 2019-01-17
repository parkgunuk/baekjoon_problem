#postfix -> infix
# enum을 사용하면 조금 더 쉬웠을 수도..
operator = ['*', '/', '+', '-']
bracket = ['(', ')']
alpabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
           'W', 'X', 'Y', 'Z']


def main():
    N = int(input())
    postfix = list(input())
    stack = []
    dict = {}


    for i in range(N):
        dict[alpabet[i]] = int(input())

    for c in postfix:
        if is_num(c):
            stack.append(dict.get(c))
        else:
            if c == '*':
                stack.append(stack.pop(-2) * stack.pop(-1))
            elif c == '/':
                stack.append(stack.pop(-2) / stack.pop(-1))
            elif c == '+':
                stack.append(stack.pop(-2) + stack.pop(-1))
            else:
                stack.append(stack.pop(-2) - stack.pop(-1))


    print("%0.2f" % stack.pop())

def is_num(x):
    if x not in operator and x not in bracket:
        return True
    else:
        return False

if __name__=="__main__":
    main()