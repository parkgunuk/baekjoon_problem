import sys
def main():
    while True:
        string = sys.stdin.readline()
        if string[0] == '#':
            break

        stack = []

        for i in range(len(string)):
            if string[i] == '<':
                idx = i
            elif string[i] == '>':
                tag = string[idx:i+1]

                if len(stack) == 0 or '/' not in tag:
                    stack.append(tag)
                elif tag[1] != '/':
                    continue
                else:
                    before = stack[-1].split()

                    if tag[2:-1] in before[0]:
                        stack.pop()
                    else:
                        break

        if len(stack) == 0 :
            print("legal")
        elif len(stack)>0:
            print("illegal")

if __name__=="__main__":
    main()