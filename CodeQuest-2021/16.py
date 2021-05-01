num = int(input())

def multiply(A, B):
    m = len(A)
    n = len(B)
 
    prod = [0] * (m + n - 1)
     
    for i in range(m):
        for j in range(n):
            prod[i + j] += A[i] * B[j]
 
    return prod
 
def printPoly(poly):
    n = len(poly)
    ans = ""
    for i in range(n):
        if poly[i]==0:
            continue
        if poly[i]!=1:
            ans+=str(poly[i])
        if (i != 0 and i!=1):
            ans+=f"x^{i}"
        if (i==1):
            ans+=f"x"
        if (i != n - 1 and abs(poly[i+1])==poly[i+1]):
            ans+="+"
    if ans=="":
        print(0)
    else:
        print(ans)


for _ in range(num):
    line1 = [int(i) for i in input().split(" ")]
    line2 = [int(i) for i in input().split(" ")]

    ans = multiply(line1, line2)
    printPoly(ans)