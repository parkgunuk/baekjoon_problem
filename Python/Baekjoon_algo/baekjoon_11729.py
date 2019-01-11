arr =[]

def main():

    N = int(input())

    hanoi(N,"1","2","3",arr)
    print(len(arr))
    for i in arr:
        print(' '.join(i))
def hanoi(n,start,tmp,target,arr):

    if n>1:
        hanoi(n-1,start,target,tmp,arr)
        arr.append([start,target])
        hanoi(n-1,tmp,start,target,arr)
    else:
        arr.append([start,target])
        return arr

if __name__=="__main__":
    main()
