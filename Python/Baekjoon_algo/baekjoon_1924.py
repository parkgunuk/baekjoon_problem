def main():
    m,d = map(int, input().split())

    for i in range(1,m):
        if i == 1 or i == 3 or i == 5 or i == 7 or i ==8 or i == 10 or i ==12:
            d += 31
        elif i == 2:
            d += 28
        else:
            d += 30

    today = d % 7
    print(switch(today))

def switch(today):
    return {
        4 : "THU",
        5 : "FRI",
        6 : "SAT",
        0 : "SUN",
        1 : "MON",
        2 : "TUE",
        3 : "WED"
    }.get(today, 9)

if __name__=="__main__":
    main()