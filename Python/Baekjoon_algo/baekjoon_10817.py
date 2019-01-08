def main():
    numbers = list(map(int, input().split()))

    numbers.pop(numbers.index(max(numbers)))

    print(max(numbers))
if __name__=="__main__":
    main()