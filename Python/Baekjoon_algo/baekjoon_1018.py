def main():
    row, col = map(int,input().split())

    ans = []
    col_ = []
    col1_ = []
    sample =[]
    sample1 = []

    paper = []

    for i in range(8):
        if i % 2 == 0:
            col_.append('W')
            col1_.append('B')
        else:
            col_.append('B')
            col1_.append('W')

    for i in range(8):
        if i % 2 == 0:
            sample.append(col_)
            sample1.append(col1_)
        else:
            sample.append(col1_)
            sample1.append(col_)

    for i in range(row):
        paper.append(list(input()))


    for r in range(row-7):
        for c in range(col-7):
            cnt = 0
            cnt1 = 0
            for rr in range(8):
                for cc in range(8):
                    if paper[r+rr][c+cc] != sample[rr][cc]:
                        cnt+=1
                    if paper[r+rr][c+cc] != sample1[rr][cc]:
                        cnt1+=1

            ans.append(cnt)
            ans.append(cnt1)
    print(min(ans))
if __name__ == "__main__":
    main()