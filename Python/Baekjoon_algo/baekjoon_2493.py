def main():
    N = int(input())
    heights = list(map(int, input().split()))
    answer = []
    length_heights = len(heights) - 1
    answer_stack = []

    for i in range(length_heights, 0, -1):
        for j in range(i - 1, -1, -1):
            if heights[i] < heights[j]:
                answer_stack.append(int(j + 1))
                heights.pop()
                break
            elif j == 0:
                answer_stack.append(int(0))
    answer_stack.append(int(0))
    for i in range(length_heights + 1):
        answer.append(answer_stack.pop())
    for i in answer:
        print(i, end=" ")
if __name__=="__main__":
    main()