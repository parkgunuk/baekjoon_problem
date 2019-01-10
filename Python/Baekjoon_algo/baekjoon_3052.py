def main():
    arr = []

    for _ in range(10):
        arr.append(int(input())%42)

    print(len(set(arr)))
if __name__=="__main__":
    main()