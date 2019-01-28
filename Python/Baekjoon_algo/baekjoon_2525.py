def main():
    A,B = map(int, input().split())
    C = int(input())

    min = (A*60+B+C)

    hour = (min//60)%24
    min = min%60

    print(str(hour)+" "+str(min))
if __name__=="__main__":
    main()