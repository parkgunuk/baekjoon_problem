#후위 표기식


operator = ['*', '/', '+', '-']
bracket = ['(', ')']

def main():
    infix = list(input())
    postfix = []
    stack = []

    for c in infix :
        if is_num(c):
            postfix.append(c)

        elif c in operator:
            p = pref(c)
            while len(stack)>0:
                top = stack[-1]
                if pref(top) < p:
                    break
                postfix.append(stack.pop())
            stack.append(c)

        elif c == '(':
            stack.append(c)
        elif c == ')':
            while True:
                x = stack.pop()
                if x == '(':
                    break
                postfix.append(x)

    while len(stack) >0:
        postfix.append(stack.pop())

    print(''.join(postfix))
def is_num(x):
    if x not in operator and x not in bracket:
        return True
    else:
        return False

def pref(x):
    if x is '*' or x is '/' :
        return 2
    elif x is '+' or x is '-':
        return 1
    else:
        return 0
if __name__=="__main__":
    main()