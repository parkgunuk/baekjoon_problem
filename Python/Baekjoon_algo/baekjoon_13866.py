def main():
    arr = list(map(int, input().split()))

    arr = sorted(arr)

    max_idx = arr.index(max(arr))
    min_idx = arr.index(min(arr))

    max_val = arr.pop(max_idx)
    min_val = arr.pop(min_idx)

    print(abs((max_val+min_val)-(arr[0]+arr[-1])))
if __name__=="__main__":
    main()