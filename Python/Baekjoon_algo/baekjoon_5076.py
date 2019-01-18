import sys
def main():
    while True:
        string = sys.stdin.readline()
        if string == '#':
            break
        tag = []
        stack = []
        for i in range(len(string)):
            if string[i] == '<':
                idx = i
            elif string[i] == '>':
                tag = string[idx:i+1]
                stack.append(tag)

        print(stack)


if __name__=="__main__":
    main()