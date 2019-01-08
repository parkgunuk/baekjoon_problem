def main():
    T = int(input())

    for case in range(T):
        grade = list(map(int, input().split()))

        N = grade.pop(0)

        avg = sum(grade) / N
        cnt = 0

        for i in grade:
            if i > avg:
                cnt+=1

        persent = round((cnt/N)*100,3)

        print("{:.3f}%".format(persent))
if __name__=="__main__":
    main()