num = int(input())
import math
def invert(C):
    a = C[0][0]
    b = C[0][1]
    c = C[1][0]
    d = C[1][1]

    coeff = 1/(a*d-b*c)
    ans = [[coeff*d, coeff*-b], [coeff*-c, coeff*a]]
    return ans
    

for _ in range(num):
    c11, c21 = [int(i) for i in input().split(" ")]
    c12, c22 = [int(i) for i in input().split(" ")]
    f1, f2 = [int(i) for i in input().split(" ")]
    F = [f1, f2]
    
    C = [[c11, c21], [c12, c22]]
    C = invert(C)


    ans = [(C[0][0]*F[0] + C[1][0]*F[1]), (C[0][1] * F[0] + C[1][1]*F[1])]
    if ans[0]>0:
        ans[0] = math.ceil(ans[0])
    else:
        ans[0] = math.floor(ans[0])
    
    if ans[1]>0:
        ans[1] = math.ceil(ans[1])
    else:
        ans[1] = math.floor(ans[1])

    print(f"{ans[0]} {ans[1]}")
    