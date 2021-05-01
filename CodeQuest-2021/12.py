num = int(input())

for _ in num:
    L, C, N = [int(i) for i in input().split(" ")]
    c=0
    n=0
    for l_ in range(L):
        if "Print" in input():
            c+=1